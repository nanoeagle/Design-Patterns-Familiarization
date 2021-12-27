package com.example.patterns.decorator.javaio;

import java.io.*;

public class LowerCaseReader extends FilterReader {
    public LowerCaseReader(Reader in) {
        super(in);
    }
    
    @Override
    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }
}