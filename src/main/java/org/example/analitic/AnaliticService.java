package org.example.analitic;

import org.example.MaxValues;
import org.example.UserData;

import java.util.Map;

public interface AnaliticService {

    MaxValues searchMaxCategory(UserData userData);

    MaxValues searchMaxCategoryForYear(UserData userData, String year);

    MaxValues searchMaxCategoryForMonth(UserData userData, String month);

    MaxValues searchMaxCategoryForDay(UserData userData, String day);
    Map.Entry<String, Integer> searchMax(Map<String, Integer> data);
}
