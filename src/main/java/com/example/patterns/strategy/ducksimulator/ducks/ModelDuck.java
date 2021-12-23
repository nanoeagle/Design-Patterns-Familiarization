package com.example.patterns.strategy.ducksimulator.ducks;

import com.example.patterns.strategy.ducksimulator.duckbehaviours.*;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new NotFly();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("I'm a model duck");
    }
}