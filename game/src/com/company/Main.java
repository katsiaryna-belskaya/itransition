package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static boolean duplicates(String[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length < 3) System.out.println("Not enough arguments.");
        else if (args.length % 2 == 0) System.out.println("Number of arguments should be an odd number.");
        else if (duplicates(args)) System.out.println("There should be no duplicates.");
        else {
            Game game = new Game(args);
            System.out.println("Enter your move: ");
            Scanner sc = new Scanner(System.in);
            int stroke = sc.nextInt();
            if (stroke != 0) {
                game.play(stroke);
            }
        }
    }
}
