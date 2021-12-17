package com.example.familiarization.strategypattern.ducks;

import com.example.familiarization.strategypattern.duckbehaviours.*;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new NotFly();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("I'm a model duck");
    }
}