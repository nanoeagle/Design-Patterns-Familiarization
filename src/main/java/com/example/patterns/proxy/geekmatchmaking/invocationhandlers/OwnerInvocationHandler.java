package com.example.patterns.proxy.geekmatchmaking.invocationhandlers;

import java.lang.reflect.*;

import com.example.patterns.proxy.geekmatchmaking.subject.Person;

public class OwnerInvocationHandler implements InvocationHandler {
    private Person person;

    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) 
    throws IllegalAccessException {
        if (method.getName().equals("addGeekRating")) 
            throw new IllegalAccessException("You cannot set your own geek rating!");
        try { return method.invoke(person, args); } 
        catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}