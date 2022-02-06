package com.example.patterns.proxy.rmisample.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.rmisample.service.*;

public class MyRemoteServiceLauncher {
    public static void main(String[] args) {
        try {
            MyRemoteService service = new MyRemoteServiceImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}