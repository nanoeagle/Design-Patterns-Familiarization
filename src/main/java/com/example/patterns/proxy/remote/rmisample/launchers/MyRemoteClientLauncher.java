package com.example.patterns.proxy.remote.rmisample.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.remote.rmisample.client.MyRemoteClient;
import com.example.patterns.proxy.remote.rmisample.service.MyRemoteService;

public class MyRemoteClientLauncher {
    public static void main(String[] args) {
        try {
            MyRemoteClient client = new MyRemoteClient();
            MyRemoteService service = (MyRemoteService) 
                Naming.lookup("rmi://localhost/RemoteHello");
            client.retrieveMessageFrom(service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}