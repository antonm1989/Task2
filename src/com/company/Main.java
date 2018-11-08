package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfNumbers = 5;
        System.out.println("Ввести " + numberOfNumbers + " чисел с консоли.");
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");


        Scanner scanner = new Scanner(System.in);
        String enteredNumbersString = scanner.nextLine();

        String enteredNumbersStringArray[] = enteredNumbersString.trim().split("\\s+");
        int enteredNumbersIntegerArray[] = new int[enteredNumbersStringArray.length];

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {
            enteredNumbersIntegerArray[i] = Integer.parseInt(enteredNumbersStringArray[i]);
        }

        int maxLentgth = 0;
        int minLength = 0;
        String longestNumber = "";
        String shortestNumber = "";

        for (String s : enteredNumbersStringArray) {
            if (s.length() > maxLentgth) {
                longestNumber = s;
                maxLentgth = s.length();
            }
        }
        System.out.println("Самое длинное число: " + longestNumber + " длина= " + maxLentgth);


        shortestNumber = enteredNumbersStringArray[0];
        minLength = shortestNumber.length();

        for (int i = 1; i < enteredNumbersStringArray.length; i++) {
            if (enteredNumbersStringArray[i].length() < shortestNumber.length()) {
                shortestNumber = enteredNumbersStringArray[i];
                minLength = shortestNumber.length();
            }
        }
        System.out.println("Самое короткое число: " + shortestNumber + " длина= " + minLength);
    }
}
