package com.example.patterns.templatemethod.mylist;

import java.util.List;

public class MyListDemo {
    public static void main(String[] args) {
        String[] ducks = { "Mallard Duck", "Redhead Duck", 
            "Rubber Duck", "Decoy Duck"};
        List<String> duckSubList = new MyStringList(ducks).subList(2, 4);
        System.out.println(duckSubList);
    }
}