package com.example.patterns.decorator.javaio;

import java.io.*;

public class JavaIO {
    public static void main(String[] args) {
        String string = "I know the Decorator Pattern therefore I RULE!";
        try (Reader reader = new LowerCaseReader(new StringReader(string))) {
            int c = 0;
            while((c = reader.read()) != -1) System.out.print((char) c);
        } catch (IOException e) { e.printStackTrace(); }
    }
}