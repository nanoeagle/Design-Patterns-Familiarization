package com.example.patterns.proxy.protection.geekmatchmaking.proxyfactory;

import java.lang.reflect.*;

import com.example.patterns.proxy.protection.geekmatchmaking.subject.Person;

public class PersonProxyFactory {
    public static Person create(Person realSubject, 
    InvocationHandler invocationHandler) {
        return (Person) Proxy.newProxyInstance( 
            realSubject.getClass().getClassLoader(),
            realSubject.getClass().getInterfaces(), invocationHandler);
    }
}