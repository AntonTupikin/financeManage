package org.example.analitic;

import org.example.MaxValues;
import org.example.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnaliticServiceImplTest {

    @Test
    void searchMaxTest() {
        AnaliticService analiticService = new AnaliticServiceImpl();
        Map<String, Integer> map = new HashMap<>();
        map.put("быт",250);
        map.put("еда",3658);
        map.put("другое",2658);

        Map.Entry<String, Integer> maxEntry = analiticService.searchMax(map);

        Assertions.assertEquals("еда",maxEntry.getKey());
    }
}