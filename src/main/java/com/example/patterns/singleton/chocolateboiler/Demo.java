package com.example.patterns.singleton.chocolateboiler;

public class Demo {
    public static void main(String[] args) {
        ChocoBoiler chocoBoiler = ChocoBoiler.INSTANCE;
        System.out.println(chocoBoiler);
        chocoBoiler = ChocoBoiler.INSTANCE;
        System.out.println(chocoBoiler);

        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        System.out.println(chocolateBoiler);
        chocolateBoiler = ChocolateBoiler.getInstance();
        System.out.println(chocolateBoiler);
    }
}