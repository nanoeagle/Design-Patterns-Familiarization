package com.example.patterns.strategy.ducksimulator;

import com.example.patterns.strategy.ducksimulator.duckbehaviours.FlyWithRocketPowered;
import com.example.patterns.strategy.ducksimulator.ducks.*;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate(new MallardDuck());
        System.out.println("-------------------------");
        
        Duck modelDuck = new ModelDuck();
        simulator.simulate(modelDuck);
        modelDuck.setFlyBehavior(new FlyWithRocketPowered());
        System.out.println("After changing the fly behavior:");
        modelDuck.performFly();
    }

    private void simulate(Duck duck) {
        duck.display();
        duck.performQuack();
        duck.performFly();
    }
}