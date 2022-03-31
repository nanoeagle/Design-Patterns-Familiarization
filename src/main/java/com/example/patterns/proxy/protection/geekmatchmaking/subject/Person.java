package com.example.patterns.proxy.protection.geekmatchmaking.subject;

public interface Person {
    String getName();
    String getGender();
    String getInterests();
    int getGeekRating();
    
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void addGeekRating(int rating);
}