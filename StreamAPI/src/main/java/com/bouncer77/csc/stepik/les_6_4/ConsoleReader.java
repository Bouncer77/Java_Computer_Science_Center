package com.bouncer77.csc.stepik.les_6_4;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.stream.Stream;

public class ConsoleReader {

    public static void main(String[] args) {
        String outputFileName = "consoleLog.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                String line;
                while(!(line = reader.readLine()).equals("exit")) {
                    writer.write(line + "\n");
                }

                Stream<String> stringStream = reader.lines();
                stringStream.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
