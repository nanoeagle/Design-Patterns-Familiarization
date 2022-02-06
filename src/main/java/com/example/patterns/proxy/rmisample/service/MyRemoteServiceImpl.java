package com.example.patterns.proxy.rmisample.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteServiceImpl extends UnicastRemoteObject 
implements MyRemoteService {
    private static final long serialVersionUID = 1L;

    public MyRemoteServiceImpl() throws RemoteException {}

    @Override
    public String sayHello() {
        return "Server says, 'Hello'";
    }
}