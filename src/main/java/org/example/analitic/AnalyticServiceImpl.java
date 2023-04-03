package org.example.analitic;

import org.example.MaxValues;
import org.example.UserData;

import java.util.Map;

public class AnalyticServiceImpl implements AnalyticService {

    public MaxValues searchMaxCategory(UserData userData) {
        Map<String, Integer> map = userData.getData();

        Map.Entry<String, Integer> maxEntry = searchMax(map);
        MaxValues maxCategory = new MaxValues("maxCategory", maxEntry.getKey(), maxEntry.getValue());
        return maxCategory;
    }
    private Map.Entry<String, Integer> searchMax(Map<String, Integer> data) {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

}
