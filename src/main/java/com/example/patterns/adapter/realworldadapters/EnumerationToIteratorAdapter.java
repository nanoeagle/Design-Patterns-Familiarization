package com.example.patterns.adapter.realworldadapters;

import java.util.*;

public class EnumerationToIteratorAdapter<E> implements Iterator<E> {
    private Enumeration<E> enumeration;

    public EnumerationToIteratorAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }
    
    @Override
    public E next() {
        return enumeration.nextElement();
    }
}