package com.example.patterns.proxy.remote.rmisample.client;

import java.rmi.RemoteException;

import com.example.patterns.proxy.remote.rmisample.service.MyRemoteService;

public class MyRemoteClient {
    public void retrieveMessageFrom(MyRemoteService service) 
    throws RemoteException {
        String message = service.sayHello();
        System.out.println(message);
    }
}