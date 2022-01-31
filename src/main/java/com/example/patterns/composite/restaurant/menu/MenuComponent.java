package com.example.patterns.composite.restaurant.menu;

public abstract class MenuComponent {
    private volatile static int count;
    
    int id;
    String name;
    String description;

    MenuComponent(String name, String description) {
        if (name.isEmpty()) 
            throw new IllegalArgumentException("name is empty!");
        if (description == null) this.description = "";
        else this.description = description;
        this.name = name;
        synchronized (MenuComponent.class) { id = count++; }
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    public abstract void print();

    public void add(MenuComponent... components) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent... component) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + description.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MenuComponent other = (MenuComponent) obj;
        if ( !name.equals(other.name)) return false;
        if ( !description.equals(other.description)) return false;
        return true;
    }
}