package com.example.geektrust;

import com.example.geektrust.InputProcessor.Executor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Executor executor = new Executor();
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                executor.executeLine(input);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
    }
}
