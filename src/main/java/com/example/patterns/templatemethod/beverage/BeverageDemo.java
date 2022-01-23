package com.example.patterns.templatemethod.beverage;

import com.example.patterns.templatemethod.beverage.caffeinebeverages.*;

public class BeverageDemo {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        System.out.println("\n...Making tea...");
        tea.prepareRecipe();

        CaffeineBeverage coffee = new Coffee();
        System.out.println("\n...Making coffee...");
        coffee.prepareRecipe();
    }
}