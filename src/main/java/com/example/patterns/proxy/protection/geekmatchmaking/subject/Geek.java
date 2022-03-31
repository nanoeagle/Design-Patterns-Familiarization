package com.example.patterns.proxy.protection.geekmatchmaking.subject;

public class Geek implements Person {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount;
    
    @Override
    public String getName() {
        return name; 
    } 
    
    @Override
    public String getGender() {
        return gender;
    }
    
    @Override
    public String getInterests() {
        return interests;
    }
    
    @Override
    public int getGeekRating() {
        return (ratingCount == 0) ? 0 : (rating / ratingCount);
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    } 
    
    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    } 
    
    @Override
    public void addGeekRating(int rating) {
        this.rating += rating; 
        ratingCount++;
    }
}