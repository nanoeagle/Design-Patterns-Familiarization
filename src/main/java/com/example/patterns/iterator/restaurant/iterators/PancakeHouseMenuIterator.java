package com.example.patterns.iterator.restaurant.iterators;

import java.util.*;

import com.example.patterns.iterator.restaurant.menu.MenuItem;

public class PancakeHouseMenuIterator implements BreakfastMenuIterator {
    private Iterator<MenuItem> itr;

    public PancakeHouseMenuIterator(List<MenuItem> items) {
        itr = items.iterator();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }

    @Override
    public MenuItem next() {
        return itr.next();
    }

    @Override
    public void remove() {
        itr.remove();
    }
}