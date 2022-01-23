package com.example.patterns.templatemethod.beverage.caffeinebeverages;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput(
            "Would you like milk and sugar with your coffee (y/n)? ");
        if (answer != null && answer.toLowerCase().startsWith("y")) 
            return true;
        return false;
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}