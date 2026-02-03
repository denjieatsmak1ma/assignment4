import controller.AccidentController;
import exception.DuplicateResourceException;
import exception.InvalidInputException;
import model.*;
import repository.AccidentRepositoryImpl;
import service.AccidentServiceImpl;
import service.interfaces.AccidentService;
import utils.ReflectionUtils;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        AccidentRepositoryImpl repo = new AccidentRepositoryImpl();
        AccidentService service = new AccidentServiceImpl(repo);
        AccidentController controller = new AccidentController(service);

        SensorData s1 = new SensorData(60.5, 2.3, LocalDateTime.now());
        SensorData s2 = new SensorData(30.0, 0.7, LocalDateTime.now());

        AccidentEvent a1 = new VehicleCollision(0, "Main street", 51.10, 71.40, 5, s1, 2);
        AccidentEvent a2 = new PedestrianAccident(0, "Central park", 51.20, 71.30, 7, s2, true);

        try {
            controller.addAccident(a1);
            controller.addAccident(a2);
        } catch (DuplicateResourceException e) {
            System.out.println("Caught DuplicateResourceException: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Caught InvalidInputException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught other error: " + e.getMessage());
        }

        System.out.println("\nReflection");
        ReflectionUtils.inspectObject(a1);
    }
}
