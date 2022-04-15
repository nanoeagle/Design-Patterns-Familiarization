package com.example.patterns.compound.ducksimulator;

import com.example.patterns.compound.ducksimulator.observable.ducks.*;
import com.example.patterns.compound.ducksimulator.observable.factories.*;
import com.example.patterns.compound.ducksimulator.observer.Quackologist;

class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate(new CountingQuackerFactory());
    }

    private void simulate(AbstractQuackerFactory quackerFactory) {
        FlockOfQuackers flockOfQuackers = createFlockOfQuackers(quackerFactory);
        FlockOfQuackers flockOfMallards = createFlockOfMallards(quackerFactory);
        flockOfQuackers.add(flockOfMallards);
        flockOfQuackers.register(new Quackologist());

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        flockOfQuackers.quack();
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        flockOfMallards.quack();

        System.out.println("\nDuck Simulator");
        System.out.println("The ducks quacked " 
            + QuackCounter.getNumberOfQuacks() + " times");
    }

    private FlockOfQuackers createFlockOfQuackers(AbstractQuackerFactory quackerFactory) {
        FlockOfQuackers flockOfQuackers = new FlockOfQuackers();
        flockOfQuackers.add(quackerFactory.createRedheadDuck());
        flockOfQuackers.add(quackerFactory.createDuckCall());
        flockOfQuackers.add(quackerFactory.createRubberDuck());
        flockOfQuackers.add(new QuackerFactory().createGooseDuck());
        return flockOfQuackers;
    }

    private FlockOfQuackers createFlockOfMallards(AbstractQuackerFactory quackerFactory) {
        FlockOfQuackers flockOfMallards = new FlockOfQuackers();
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        flockOfMallards.add(quackerFactory.createMallardDuck());
        return flockOfMallards;
    }
}