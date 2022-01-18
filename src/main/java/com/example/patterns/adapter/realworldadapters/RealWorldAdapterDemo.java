package com.example.patterns.adapter.realworldadapters;

import java.util.*;

public class RealWorldAdapterDemo {
    public static void main(String[] args) {
        RealWorldAdapterDemo demo = new RealWorldAdapterDemo();
        System.out.println("--- Testing EnumerationToIteratorAdapter ---");
        demo.testEnumerationToIteratorAdapter();
        System.out.println("\n--- Testing IteratorToEnumerationAdapter ---");
        demo.testIteratorToEnumerationAdapter();
    }

    private void testEnumerationToIteratorAdapter() {
        Properties props = createMockProperties();
        Iterator<Object> iterator = 
            new EnumerationToIteratorAdapter<>(props.keys());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if ( !iterator.hasNext() ) 
                try {
                    iterator.remove();
                } catch (UnsupportedOperationException e) {
                    System.out.println(e.toString());
                }
        }
    }

    private Properties createMockProperties() {
        Properties props = new Properties();
        props.setProperty("First name", "Juan");
        props.setProperty("Last name", "Don");
        props.setProperty("DOB", "19/12/1980");
        return props;
    }

    private void testIteratorToEnumerationAdapter() {
        List<String> food = List.of("Pizza", "Hotdog", "Sausage");
        Enumeration<String> enumeration =
            new IteratorToEnumerationAdapter<>(food.iterator());
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
}