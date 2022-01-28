package com.example.patterns.iterator.restaurant.iterators;

import java.util.Iterator;

import com.example.patterns.iterator.restaurant.menu.MenuItem;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int itemIndex;
    
    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (itemIndex >= items.length || items[itemIndex] == null) 
            return false;
        else return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[itemIndex];
        itemIndex++;
        return menuItem;
    }
}