package org.example;

import org.example.statistic.Statistic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData implements Serializable {
    private Map<String, Integer> data = new HashMap<>();
    private Categories categories = new Categories();
    private List<Purchase> purchases = new ArrayList<>();
    private Statistic statistic = new Statistic();


    public Statistic getStatistic() {
        return statistic;
    }

    public void setMaxCategory(MaxValues maxCategory) {
        statistic.setMaxCategory(maxCategory);
    }

    public void addToData(Purchase purchase) {
        this.purchases.add(purchase);
        String category = "";
        if (categories.getCategories().get(purchase.getTitle()) != null) {
            category = categories.getCategories().get(purchase.getTitle());
        } else {
            category = "другое";
        }
        if (data.get(category) != null) {
            int sum = data.get(category) + purchase.getSum();
            data.put(category, sum);
        } else {
            data.put(category, purchase.getSum());
        }
        System.out.println(this.data.toString());
    }

    public Map<String, Integer> getData() {
        return this.data;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}
