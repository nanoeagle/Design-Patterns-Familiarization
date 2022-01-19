package com.example.patterns.adapter.fowlsimulator.adapters;

import com.example.patterns.adapter.fowlsimulator.fowl.*;

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