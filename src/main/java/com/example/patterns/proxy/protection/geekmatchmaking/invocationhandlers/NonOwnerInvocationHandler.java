package com.example.patterns.proxy.protection.geekmatchmaking.invocationhandlers;

import java.lang.reflect.*;

import com.example.patterns.proxy.protection.geekmatchmaking.subject.Person;

public class NonOwnerInvocationHandler implements InvocationHandler {
    private Person person;

    public NonOwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) 
    throws IllegalAccessException {
        String methodName = method.getName();
        if (methodName.startsWith("set")) 
            throw new IllegalAccessException("You must not set others's info!");
        try { return method.invoke(person, args); } 
        catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}