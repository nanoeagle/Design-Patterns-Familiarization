package com.example.patterns.adapter.fowlsimulator.adapters;

import java.util.ArrayList;

import com.example.patterns.adapter.fowlsimulator.fowl.Duck;
import com.example.patterns.adapter.fowlsimulator.fowl.Turkey;

public class TurkeyToDuckAdapter implements Duck {
    private Turkey turkey;
    
    public TurkeyToDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    
    @Override
    public void quack() {
        turkey.gobble();
    }
    
    @Override
    public void fly() {
        for(int i = 0; i < 5; i++) turkey.fly();
    }
}