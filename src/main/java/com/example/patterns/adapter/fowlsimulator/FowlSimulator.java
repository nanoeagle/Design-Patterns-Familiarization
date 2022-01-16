package com.example.patterns.adapter.fowlsimulator;

import com.example.patterns.adapter.fowlsimulator.adapters.*;
import com.example.patterns.adapter.fowlsimulator.fowl.*;

public class FowlSimulator {
    public static void main(String[] args) {
        FowlSimulator simulator = new FowlSimulator();

        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyToDuckAdapter = new TurkeyToDuckAdapter(turkey);
        Turkey duckToTurkeyAdapter = new DuckToTurkeyAdapter(duck);
        
        System.out.println("The Turkey says...");
        simulator.testTurkey(turkey);
        System.out.println("\nThe Duck says...");
        simulator.testDuck(duck);
        
        System.out.println("\nThe TurkeyToDuckAdapter says...");
        simulator.testDuck(turkeyToDuckAdapter);
        System.out.println("\nThe DuckToTurkeyAdapter says...");
        simulator.testTurkey(duckToTurkeyAdapter);
    }
    
    private void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    private void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }
}