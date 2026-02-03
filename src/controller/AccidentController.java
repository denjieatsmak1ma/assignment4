package controller;

import model.AccidentEvent;
import service.interfaces.AccidentService;
import java.util.List;

public class AccidentController {

    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    public void addAccident(AccidentEvent a) {
        service.addAccident(a);
        System.out.println("Added: " + a.getAccidentSummary());
    }

    public void updateAccident(AccidentEvent a) {
        service.updateAccident(a);
        System.out.println("Updated: " + a.getAccidentSummary());
    }

    public void deleteAccident(int id) {
        service.deleteAccident(id);
        System.out.println("Deleted id=" + id);
    }

    public AccidentEvent getAccidentById(int id) {
        return service.getAccidentById(id);
    }

    public List<AccidentEvent> getAllAccidentsSortedBySeverity() {
        return service.getAllAccidentsSortedBySeverity();
    }
}
