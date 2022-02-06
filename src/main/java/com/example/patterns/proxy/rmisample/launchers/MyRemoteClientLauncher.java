package com.example.patterns.proxy.rmisample.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.rmisample.client.MyRemoteClient;
import com.example.patterns.proxy.rmisample.service.MyRemoteService;

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