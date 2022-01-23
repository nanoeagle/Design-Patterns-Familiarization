package com.example.patterns.templatemethod.beverage.caffeinebeverages;

import java.io.*;

public abstract class CaffeineBeverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) addCondiments();
    }

    final void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void brew();
    
    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // This method acts as a hook.
    boolean customerWantsCondiments() {
        return true;
    }

    abstract void addCondiments();
        
    final String getUserInput(String message) {
        System.out.print(message);
        String answer = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println(e);
        }
        return answer;
    }
}