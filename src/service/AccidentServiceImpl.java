package service;

import exception.DatabaseOperationException;
import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.AccidentEvent;
import repository.interfaces.CrudRepository;
import service.interfaces.AccidentService;
import utils.SortingUtils;

import java.util.List;

public class AccidentServiceImpl implements AccidentService {

    private final CrudRepository<AccidentEvent> repository;

    public AccidentServiceImpl(CrudRepository<AccidentEvent> repository) {
        this.repository = repository;
    }

    private void validate(AccidentEvent a) {
        if (a == null) throw new InvalidInputException("Accident cannot be null");
        if (a.getLocation() == null || a.getLocation().trim().isEmpty())
            throw new InvalidInputException("Location cannot be empty");
        if (a.getSeverity() < 1 || a.getSeverity() > 10)
            throw new InvalidInputException("Severity must be 1..10");
    }

    @Override
    public void addAccident(AccidentEvent accident) {
        validate(accident);

        try {
            boolean duplicate = repository.findAll().stream()
                    .anyMatch(a -> a.getLatitude() == accident.getLatitude()
                            && a.getLongitude() == accident.getLongitude());

            if (duplicate) throw new DuplicateResourceException("Duplicate coordinates!");

            repository.create(accident);

        } catch (DuplicateResourceException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new DatabaseOperationException("DB error while adding accident", e);
        }
    }

    @Override
    public AccidentEvent getAccidentById(int id) {
        if (id <= 0) throw new InvalidInputException("Id must be positive");
        try {
            return repository.read(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new DatabaseOperationException("DB error while reading accident", e);
        }
    }

    @Override
    public void updateAccident(AccidentEvent accident) {
        validate(accident);
        if (accident.getId() <= 0) throw new InvalidInputException("Id must be positive for update");

        try {
            repository.update(accident);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new DatabaseOperationException("DB error while updating accident", e);
        }
    }

    @Override
    public void deleteAccident(int id) {
        if (id <= 0) throw new InvalidInputException("Id must be positive");
        try {
            repository.delete(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new DatabaseOperationException("DB error while deleting accident", e);
        }
    }

    @Override
    public List<AccidentEvent> getAllAccidentsSortedBySeverity() {
        try {
            List<AccidentEvent> all = repository.findAll();
            SortingUtils.sortBySeverity(all);
            return all;
        } catch (RuntimeException e) {
            throw new DatabaseOperationException("DB error while fetching accidents", e);
        }
    }
}
