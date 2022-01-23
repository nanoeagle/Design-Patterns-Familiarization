package com.example.patterns.templatemethod.duckie;

import java.util.Arrays;

public class DuckieDemo {
    public static void main(String[] args) {
        RubberDuck[] ducks = { 
            new RubberDuck("Daffy", 8), 
            new RubberDuck("Dewey", 2),
            new RubberDuck("Howard", 7),
            new RubberDuck("Louie", 4),
            new RubberDuck("Donald", 10), 
            new RubberDuck("Huey", 1)};
        
        DuckieDemo demo = new DuckieDemo();
        System.out.println("Before sorting:");
        demo.display(ducks);

        Arrays.sort(ducks);
        System.out.println("\nAfter sorting:");
        demo.display(ducks);
    }

    private void display(RubberDuck[] ducks) {
        for (RubberDuck duck : ducks) System.out.println(duck);
    }  
}