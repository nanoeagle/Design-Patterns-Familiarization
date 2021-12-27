package com.example.patterns.decorator.starbuzz.beverages;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI };
    
    private String description;
    private Size size;

    public Beverage() {
        description = "Unknown Beverage";
        size = Size.TALL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    public abstract float cost();
}