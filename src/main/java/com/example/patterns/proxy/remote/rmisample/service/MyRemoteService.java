package com.example.patterns.proxy.remote.rmisample.service;

import java.rmi.*;

public interface MyRemoteService extends Remote {
    String sayHello() throws RemoteException;
}