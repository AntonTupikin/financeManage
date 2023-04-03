package org.example.statistic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.MaxValues;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Serializable;

public class Statistic implements Serializable {
    private MaxValues maxCategory;


    public void setMaxCategory(MaxValues maxCategory) {
        this.maxCategory = maxCategory;
    }

    public static Statistic parseStatistic(String answer) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(answer);
            JSONObject jsonObject = (JSONObject) obj;
            String s = jsonObject.toJSONString();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Statistic statistic = gson.fromJson(s, Statistic.class);
            return statistic;
        } catch (ParseException e) {
            e.printStackTrace();
            Statistic statistic = new Statistic();
            return statistic;
        }
    }

    @Override
    public String toString() {
        return maxCategory.toString() + "\n";
    }


}
