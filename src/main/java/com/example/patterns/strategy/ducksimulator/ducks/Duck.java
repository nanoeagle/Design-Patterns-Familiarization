package com.example.patterns.strategy.ducksimulator.ducks;

import com.example.patterns.strategy.ducksimulator.duckbehaviours.*;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    } 

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();
}