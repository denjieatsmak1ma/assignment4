import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url="jdbc:postgresql://localhost:5432/accident";
    private static final String user="postgres";
    private static final String password="AminaT123";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e){
            throw new RuntimeException("Database connection failed",e);
        }
    }
}
