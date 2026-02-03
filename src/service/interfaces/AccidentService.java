package service.interfaces;

import exception.DuplicateResourceException;
import model.AccidentEvent;

import java.util.List;

public interface AccidentService {
    void addAccident(AccidentEvent accident) throws DuplicateResourceException;
    AccidentEvent getAccidentById(int id);
    void updateAccident(AccidentEvent accident);
    void deleteAccident(int id);
    List<AccidentEvent> getAllAccidentsSortedBySeverity();
}

