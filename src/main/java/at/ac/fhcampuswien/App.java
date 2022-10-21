package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {


    public static void oneMonthCalendar(int totalDays, int startingDay) {
        // The following lines 11-25 have been taken from the internet.| https://stackoverflow.com/questions/64054639/how-to-properly-print-month-calendar-on-terminal, 19.10.2022
        int position;

        for (position = 1; position < startingDay; position++) {
            System.out.print("   ");
        }

        for (position = 1; position <= totalDays; position++) {
            if (position < 10) {
                System.out.print(" " + position + " ");
            }
            else {
                System.out.print(position + " ");
            }
            if ((startingDay + position -1) % 7 == 0) {
                System.out.println();
            }
            if ((position == totalDays) && ((startingDay + position -1) % 7 != 0)) {
                System.out.println();
            }
        }
    }

    public static long[] lcg(long seed) {
        long[] generatedNumbers = new long[10];
        final long M = (long) Math.pow(2, 31.0);
        final long C = 12345;
        final long A = 1103515245;

        for (int index = 0; index < generatedNumbers.length; index++) {
            generatedNumbers[index] = (A * seed + C) % M;
            seed = generatedNumbers[index];
        }
        return generatedNumbers;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        System.out.print("Guess number "+counter+": ");
        int input = scanner.nextInt();

        if (input == numberToGuess) {
            System.out.println("You won wisenheimer!");
        }
        else {
            if (input < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (input > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            }
            counter += 1;
        }
        while ((input != numberToGuess) && (counter <= 10)) {
            System.out.print("Guess number "+counter+": ");
            input = scanner.nextInt();
            if ((counter == 10) && (input != numberToGuess)) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (input < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (input > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            }
            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            counter += 1;

        }


    }

    public static boolean swapArrays(int[] array1, int[] array2) {

        // return false if array length is not equal
        if (array1.length != array2.length) {
            return false;
        }

        for (int index = 0; index < array1.length; index++) {
            int cache = array1[index];
            array1[index] = array2[index];
            array2[index] = cache;
        }
        return true;
    }

    public static String camelCase(String sentence) {
        char[] charArray= sentence.toCharArray();

        // upper from 65-90
        // lower 97-122
        // delete = 127
        for (int i = 1; i < charArray.length; i++) {
            // process first element of array
            int startAscii = charArray[0];
            if ((startAscii >= 97) && (startAscii <= 122)) {
                int newStartAscii = startAscii - 32;
                char converted = (char) newStartAscii;
                charArray[0] = converted;
            }
            //process the rest
            int ascii = charArray[i];
            if ((ascii >= 65) && (ascii <= 90)) {
                int stepBack = i -1;
                int check = charArray[stepBack];
                if ((check >= 97) && (check <= 122)) {
                    int newAscii = ascii + 32;
                    char converted = (char) newAscii;
                    charArray[i] = converted;
                }
                if (((check >= 65) && (check <= 90))) {
                    int newAscii = ascii + 32;
                    char converted = (char) newAscii;
                    charArray[i] = converted;
                }

            }
            if ((ascii >= 97) && (ascii <= 122)) {
                int stepBack = i -1;
                int check = charArray[stepBack];
                if (check == 32) {
                    int newAscii = ascii - 32;
                    char converted = (char) newAscii;
                    charArray[i] = converted;
                }

            }
        }
        int counter = 0;
        for (int i = 0; i < charArray.length; i++) {
            int ascii = charArray[i];
            if (((ascii >= 65) && (ascii <= 90)) || ((ascii >= 97) && (ascii <= 122))) {
                counter += 1;
            }
        }
        char[] finalArray = new char[counter];

        int newIndex = 0;
        for (int i = 0; i < charArray.length; i++) {

            int ascii = charArray[i];
            if (((ascii >= 65) && (ascii <= 90)) || ((ascii >= 97) && (ascii <= 122))) {
                char newAscii = (char) ascii;
                finalArray[newIndex] = newAscii;
                newIndex += 1;
            }
        }
        StringBuilder builder = new StringBuilder();

        String result = String.valueOf(builder.append(finalArray));
        return result;
    }

    public static int checkDigit(int[] code) {
        int codeLength = code.length;
        int[] weightedArray = new int[codeLength];
        int[] productArray = new int[codeLength];

        // copy elements from code to second and create weighted values
        for (int index = 0; index < codeLength; index++) {
            weightedArray[index] = index + 2;
        }
        int weightedLength = weightedArray.length;
        int sum = 0;
        // builds products of number with their corresponding weighted counterpart
        for (int index = 0; index < codeLength; index++) {
            productArray[index] = code[index] * weightedArray[index];
            sum += productArray[index];
        }
        // calculate the actual check digit
        int modulo = sum % 11;
        int digit = 11 - modulo;
        if (digit == 10) {
            return 0;
        }
        if (digit == 11) {
            return 5;
        }
        return digit;
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(99)+1;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        int randomNumber = randomNumberBetweenOneAndHundred();
        guessingGame(randomNumber);

        String test = "an oYster more.";
        String returnString = camelCase(test);
        System.out.println(returnString);
    }
}