package utils;

import model.AccidentEvent;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {
    public static void sortBySeverity(List<AccidentEvent> list) {
        list.sort(Comparator.comparingInt(AccidentEvent::getSeverity));
    }
}
