package com.company;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

enum Result {
    PC,
    USER,
    DRAW
}

public class Game {
    String[] combinations;
    int stroke;
    int userstroke;
    byte[] key;
    byte[] hmac;
    Result result;

    public Game(String[] args) {
        this.combinations = args;
        Random generator = new Random();
        int randomIndex = generator.nextInt(this.combinations.length);
        stroke = ThreadLocalRandom.current().nextInt(1, args.length + 1);
        this.sethmac();
        System.out.println(String.format("HMAC: %032x", new BigInteger(1, hmac)));
        showmoves(args);
    }

    public void sethmac() {
        SecureRandom secureRandomGenerator = new SecureRandom();
        key = new byte[16]; // 16 bytes = 128 bits
        secureRandomGenerator.nextBytes(key);
        hmac = HMAC.calcHmacSha256(key, BigInteger.valueOf(stroke).toByteArray());
    }

    public static void showmoves(String[] args) {
        System.out.println("Available moves:");
        for (int i = 1; i < args.length + 1; ++i) {
            System.out.println(i + "-" + args[i - 1]);
        }
        System.out.println("0:exit");
    }

    public void play(int stroke) {
        userstroke = stroke;
        if (userstroke <= combinations.length) {
            System.out.println("Your move: " + combinations[userstroke - 1]);
            System.out.println("Computer move:" + combinations[this.stroke - 1]);
            this.checkwin();
            switch (result) {
                case PC:
                    System.out.println("Computer wins!");
                    break;
                case USER:
                    System.out.println("You win!");
                    break;
                case DRAW:
                    System.out.println("Draw!");
                    break;
            }
            System.out.println(String.format("HMAC key: %032x", new BigInteger(1, key)));
        }
    }

    public void checkwin() {
        if (stroke == userstroke) result = Result.DRAW;
        else {
            int interval = (combinations.length / 2);
            int check = 0;
            if (stroke == combinations.length)
                for (int i = 1; i <= interval; i++) {
                    if (userstroke == i) {
                        result = Result.USER;
                        return;
                    }
                }
            else {
                for (int i = stroke + 1; i <= combinations.length; i++) {
                    check++;
                    if (userstroke == i) {
                        result = Result.USER;
                        return;
                    }
                    if (check == interval) {
                        result = Result.PC;
                        return;
                    }
                }
            }
            for (int i = 1; i <= interval - check; i++)
                if (userstroke == i) {
                    result = Result.USER;
                    return;
                }
            result = Result.PC;
        }
    }
}
