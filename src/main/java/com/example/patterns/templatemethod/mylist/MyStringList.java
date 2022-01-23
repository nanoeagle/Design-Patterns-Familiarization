package com.example.patterns.templatemethod.mylist;

import java.util.AbstractList;

public class MyStringList extends AbstractList<String> {
    private String[] stringArray;
    
    public MyStringList(String[] stringArray) {
        this.stringArray = stringArray;
    }
    
    @Override
    public String get(int index) {
        return stringArray[index];
    }

    @Override
    public int size() {
        return stringArray.length;
    }

    @Override
    public String set(int index, String item) {
        String oldString = stringArray[index];
        stringArray[index] = item;
        return oldString;
    }
}