package com.mikalai.spring.profile.school;

import java.util.ArrayList;
import java.util.List;

import com.mikalai.spring.profile.Food;
import com.mikalai.spring.profile.FoodProviderService;

public class FoodService implements FoodProviderService {

    @Override
    public List<Food> provideLunchSet() {
        List<Food> list = new ArrayList<Food>();
        list.add(new Food("Coke"));
        list.add(new Food("Hamburger"));
        return list;
    }

}
