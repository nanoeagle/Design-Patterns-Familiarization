package com.example.patterns.adapter.realworldadapters;

import java.util.*;

public class IteratorToEnumerationAdapter<E> implements Enumeration<E> {
    private Iterator<E> iterator;

    public IteratorToEnumerationAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}