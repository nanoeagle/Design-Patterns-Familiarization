package com.example.patterns.state.mightygumball;

import com.example.patterns.state.mightygumball.machine.GumballMachine;

public class MightyGumballDemo {
    private GumballMachine gumballMachine;

    MightyGumballDemo(int initialGumballs) {
        gumballMachine = new GumballMachine(initialGumballs);
    }

    public static void main(String[] args) {
        MightyGumballDemo demo = new MightyGumballDemo(5);
        System.out.println(demo.gumballMachine);

        demo.gumballMachine.turnCrank();
        for (int i = 0; i < 2; i++) demo.testBuyingGumball();
        
        demo.testQuarterRelatedActions();
        demo.testRefillingWhenFail();
        demo.testRefillingWhenPass();
        for (int i = 0; i < 5; i++) demo.testBuyingGumball();
    }

    private void testBuyingGumball() {
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }

    private void testQuarterRelatedActions() {
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        System.out.println(gumballMachine);
    }
    
    private void testRefillingWhenFail() {
        gumballMachine.insertQuarter();
        try {
            gumballMachine.refillWith(2);
            
        } catch (Exception e) {
            System.out.println("Fail when refilling: " + e.getMessage());
        }
        gumballMachine.ejectQuarter();

        try {
            gumballMachine.refillWith(0);
        } catch (Exception e) {
            System.out.println("Fail when refilling: " + e.getMessage());
        }
        System.out.println(gumballMachine);
    }

    private void testRefillingWhenPass() {
        gumballMachine.refillWith(2);
        System.out.println(gumballMachine);
    }
}