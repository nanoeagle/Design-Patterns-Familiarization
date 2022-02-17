package com.example.patterns.compound.ducksimulator;

import com.example.patterns.compound.ducksimulator.observable.quacker.*;
import com.example.patterns.compound.ducksimulator.observable.quacker.factories.*;
import com.example.patterns.compound.ducksimulator.observer.Quackologist;

class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate(new CountingQuackerFactory());
    }
        
    private void simulate(AbstractQuackerFactory quackerFactory) {
        Flock flockOfQuackers = createFlockOfQuackers(quackerFactory);
        Flock flockOfMallards = createFlockOfMallards(quackerFactory);
        flockOfQuackers.add(flockOfMallards);
        flockOfQuackers.registerObserver(new Quackologist());

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        flockOfQuackers.quack();
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        flockOfMallards.quack();

        System.out.println("\nDuck Simulator");
        System.out.println("The ducks quacked " 
            + QuackCounter.getNumberOfQuacks() + " times");
    }

    private Flock createFlockOfQuackers(AbstractQuackerFactory quackerFactory) {
        Flock flockOfQuackers = new Flock();
        flockOfQuackers.add(quackerFactory.createRedheadDuck());
        flockOfQuackers.add(quackerFactory.createDuckCall());
        flockOfQuackers.add(quackerFactory.createRubberDuck());
        flockOfQuackers.add(new QuackerFactory().createGooseDuck());
        return flockOfQuackers;
    }

    private Flock createFlockOfMallards(AbstractQuackerFactory quackerFactory) {
        Flock flockOfMallards = new Flock();
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        return flockOfMallards;
    }
}