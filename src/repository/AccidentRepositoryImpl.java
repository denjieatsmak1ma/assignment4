package repository;

import exception.ResourceNotFoundException;
import model.*;
import repository.interfaces.CrudRepository;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccidentRepositoryImpl implements CrudRepository<AccidentEvent> {

    private final Connection connection;

    public AccidentRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(AccidentEvent a) {
        String sqlEvent = "INSERT INTO accident_events (type, location, latitude, longitude, severity) VALUES (?, ?, ?, ?, ?)";
        String sqlSensor = "INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp) VALUES (?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

        
            try (PreparedStatement st = connection.prepareStatement(sqlEvent, Statement.RETURN_GENERATED_KEYS)) {
                st.setString(1, a.getAccidentType());
                st.setString(2, a.getLocation());
                st.setDouble(3, a.getLatitude());
                st.setDouble(4, a.getLongitude());
                st.setInt(5, a.getSeverity());
                st.executeUpdate();

                ResultSet keys = st.getGeneratedKeys();
                if (keys.next()) {
                    a.setId(keys.getInt(1));
                }
            }

           
            SensorData s = a.getSensorData();
            if (s != null) {
                try (PreparedStatement st2 = connection.prepareStatement(sqlSensor, Statement.RETURN_GENERATED_KEYS)) {
                    st2.setInt(1, a.getId());
                    st2.setDouble(2, s.getSpeed());
                    st2.setDouble(3, s.getAcceleration());
                    st2.setTimestamp(4, Timestamp.valueOf(s.getTimestamp()));
                    st2.executeUpdate();

                    ResultSet keys2 = st2.getGeneratedKeys();
                    if (keys2.next()) {
                        s.setId(keys2.getInt(1));
                    }
                }
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            try { connection.rollback(); } catch (SQLException ignored) {}
            throw new RuntimeException("Error creating accident", e);
        }
    }

    @Override
    public AccidentEvent read(int id) {
        String sql =
                "SELECT e.id, e.type, e.location, e.latitude, e.longitude, e.severity, " +
                        "s.id AS sid, s.speed, s.acceleration, s.timestamp " +
                        "FROM accident_events e " +
                        "LEFT JOIN sensor_data s ON s.accident_id = e.id " +
                        "WHERE e.id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (!rs.next()) throw new ResourceNotFoundException("Accident not found: " + id);

            String type = rs.getString("type");
            String location = rs.getString("location");
            double lat = rs.getDouble("latitude");
            double lon = rs.getDouble("longitude");
            int sev = rs.getInt("severity");

            SensorData sensor = null;
            int sid = rs.getInt("sid");
            if (!rs.wasNull()) {
                double speed = rs.getDouble("speed");
                double acc = rs.getDouble("acceleration");
                Timestamp ts = rs.getTimestamp("timestamp");
                sensor = new SensorData(sid, speed, acc, ts.toLocalDateTime());
            }

            
            if ("PEDESTRIAN_ACCIDENT".equals(type)) {
                return new PedestrianAccident(id, location, lat, lon, sev, sensor, false);
            } else {
                return new VehicleCollision(id, location, lat, lon, sev, sensor, 1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error reading accident", e);
        }
    }

    @Override
    public void update(AccidentEvent a) {
        String sql = "UPDATE accident_events SET location=?, latitude=?, longitude=?, severity=? WHERE id=?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, a.getLocation());
            st.setDouble(2, a.getLatitude());
            st.setDouble(3, a.getLongitude());
            st.setInt(4, a.getSeverity());
            st.setInt(5, a.getId());

            int rows = st.executeUpdate();
            if (rows == 0) throw new ResourceNotFoundException("Accident not found for update: " + a.getId());

        } catch (SQLException e) {
            throw new RuntimeException("Error updating accident", e);
        }
    }

    @Override
    public void delete(int id) {
        
        String sql = "DELETE FROM accident_events WHERE id=?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            int rows = st.executeUpdate();
            if (rows == 0) throw new ResourceNotFoundException("Accident not found for delete: " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting accident", e);
        }
    }

    @Override
    public List<AccidentEvent> findAll() {
        String sql = "SELECT id FROM accident_events ORDER BY id";
        List<AccidentEvent> list = new ArrayList<>();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(read(rs.getInt("id")));
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching accidents", e);
        }
    }
}
