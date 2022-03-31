package com.example.patterns.proxy.protection.geekmatchmaking;

import com.example.patterns.proxy.protection.geekmatchmaking.invocationhandlers.*;
import com.example.patterns.proxy.protection.geekmatchmaking.proxyfactory.PersonProxyFactory;
import com.example.patterns.proxy.protection.geekmatchmaking.subject.*;

class GeekMatchmakingDemo {
    public static void main(String[] args) {
        GeekMatchmakingDemo demo = new GeekMatchmakingDemo();
        demo.run();
    }

    private void run() {
        Person kelly = createPerson(
            "Kelly Klosure", "female", "ebay, movies, music", 7);
        testOwnerProxyFor(kelly);
        testNonOwnerProxyFor(kelly);
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