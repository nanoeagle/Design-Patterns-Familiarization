package com.example.patterns.proxy.geekmatchmaking;

import java.util.*;

import com.example.patterns.proxy.geekmatchmaking.invocationhandlers.*;
import com.example.patterns.proxy.geekmatchmaking.protectionproxy.PersonProxyFactory;
import com.example.patterns.proxy.geekmatchmaking.subject.*;

class GeekMatchmakingDemo {
    private Map<String, Person> personDB = new HashMap<>();

    public static void main(String[] args) {
        GeekMatchmakingDemo demo = new GeekMatchmakingDemo();
        demo.run();
    }

    GeekMatchmakingDemo() {
        initializeDatabase();
    }
    
    private void initializeDatabase() {
        Person joe = createPerson(
            "Joe Javabean", "male", "cars, computers, music", 7);
        Person kelly = createPerson(
            "Kelly Klosure", "female", "ebay, movies, music", 6);
        personDB.put(joe.getName(), joe);
        personDB.put(kelly.getName(), kelly);
    }

    private Person createPerson(String name, String gender, 
    String interests, int initialRating) {
        Geek geek = new Geek();
        geek.setName(name);
        geek.setGender(gender);
        geek.setInterests(interests);
        geek.addGeekRating(initialRating);
        return geek;
    }

    private void run() {
        Person joe = personDB.get("Joe Javabean"); 
        testOwnerProxyFor(joe);
        testNonOwnerProxyFor(joe);
    }

    private void testOwnerProxyFor(Person person) {
        Person ownerProxy = createOwnerProxyFor(person);
        System.out.println("\nName is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");

        try { ownerProxy.addGeekRating(10); } 
        catch (Exception e) { System.out.println(e.getCause().getMessage()); }
        System.out.println("Rating is " + ownerProxy.getGeekRating());
    }

    private Person createOwnerProxyFor(Person person) {
        return PersonProxyFactory.create(
            person, new OwnerInvocationHandler(person));
    }

    private void testNonOwnerProxyFor(Person person) {
        Person nonOwnerProxy = createNonOwnerProxyFor(person);
        System.out.println("\nName is " + nonOwnerProxy.getName());

        try { nonOwnerProxy.setInterests("bowling, Go"); } 
        catch (Exception e) { System.out.println(e.getCause().getMessage()); }
        nonOwnerProxy.addGeekRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getGeekRating());
    }

    private Person createNonOwnerProxyFor(Person person) {
        return PersonProxyFactory.create(
            person, new NonOwnerInvocationHandler(person));
    }
}