package com.example.patterns.templatemethod.duckie;

public class RubberDuck implements Comparable<RubberDuck> {
    private String name;
    private int weight;
    
    public RubberDuck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " weighs " + weight;
    }
    
    @Override
    public int compareTo(RubberDuck otherDuck) {
        return weight - otherDuck.weight;
    }
}