package com.study;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReading {
   String processLine(BufferedReader bufferedReader) throws IOException;
}
