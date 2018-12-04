package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int numberOfNumbers = 5;
        System.out.println("Ввести " + numberOfNumbers + " чисел с консоли:");

        Scanner scanner = new Scanner(System.in);
        String enteredNumbersString = scanner.nextLine();
        System.out.println();
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");

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
        System.out.println("Самое длинное число: " + longestNumber + ", его длина= " + maxLentgth);


        shortestNumber = enteredNumbersStringArray[0];
        minLength = shortestNumber.length();

        for (int i = 1; i < enteredNumbersStringArray.length; i++) {
            if (enteredNumbersStringArray[i].length() < shortestNumber.length()) {
                shortestNumber = enteredNumbersStringArray[i];
                minLength = shortestNumber.length();
            }
        }
        System.out.println("Самое короткое число: " + shortestNumber + ", его длина= " + minLength);

        System.out.println();
        System.out.println("2. Упорядочить и вывести числа в порядке возрастания (убывания) " +
                "значений их длины.");

        String bufferString = "";

        for (int i = enteredNumbersStringArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {

                if (enteredNumbersStringArray[j].length() > enteredNumbersStringArray[j + 1].length()) {
                    bufferString = enteredNumbersStringArray[j];
                    enteredNumbersStringArray[j] = enteredNumbersStringArray[j + 1];
                    enteredNumbersStringArray[j + 1] = bufferString;

                }
            }
        }

        System.out.println(Arrays.toString(enteredNumbersStringArray));

        System.out.println();
        System.out.println("3. Вывести на консоль те числа, длина которых меньше" +
                " (больше) средней, а также длину.");

        int averageLentgth = 0;

        for (String s : enteredNumbersStringArray) {
            averageLentgth = averageLentgth + s.length();
        }

        averageLentgth = averageLentgth / enteredNumbersStringArray.length;
        System.out.println("средняя длина =  " + averageLentgth);
        System.out.println("числа, длина которых меньше средней:");
        for (String s : enteredNumbersStringArray) {
            if (s.length() < averageLentgth) {
                System.out.println("число= " + s + ", длина= " + s.length());
            }
        }

        System.out.println("числа, длина которых больше средней:");
        for (String s : enteredNumbersStringArray) {
            if (s.length() > averageLentgth) {
                System.out.println("число= " + s + ", длина= " + s.length());
            }
        }

        System.out.println();
        System.out.println("4. Найти число, в котором число различных цифр минимально. Если таких чисел " +
                "несколько, найти первое из них.");

        int counterArray[][] = new int[enteredNumbersStringArray.length][10];

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {

            byte bytes[] = new byte[enteredNumbersStringArray[i].length()];

            for (int i1 = 0; i1 < enteredNumbersStringArray[i].length(); i1++) {

                bytes[i1] = enteredNumbersStringArray[i].getBytes()[i1];
            }


            for (int j = 0; j < bytes.length; j++) {

                counterArray[i][Integer.parseInt("" + (char) bytes[j])]++;
            }

        }


        int maximumDifferentDigits = 0;
        int sumOfSimilarDigits[] = new int[enteredNumbersStringArray.length];

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {
            for (int j = 0; j < enteredNumbersStringArray[i].length(); j++) {
                if (counterArray[i][j] > 1) {
                    sumOfSimilarDigits[i] += counterArray[i][j];
                }
            }
        }

        String temp = "";
        for (int i = 0; i < sumOfSimilarDigits.length; i++) {
            if (sumOfSimilarDigits[i] > maximumDifferentDigits) {
                maximumDifferentDigits = sumOfSimilarDigits[i];
                temp = enteredNumbersStringArray[i];
            }

        }
        if (temp.length() > 0) {
            System.out.println(temp);
        } else {
            System.out.println("чисел с одинаковыми цифрами не найдено");
        }

        System.out.println();
        System.out.println("5. Найти количество чисел, содержащих только четные цифры, " +
                "а среди них количество чисел с равным числом четных и нечетных цифр.");

        int numberOfOnlyEvenDigits = 0;
        String onlyEvenDigits = "";
        String sameEvenOddDigitsAmount = "";

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {

            byte bytes[] = new byte[enteredNumbersStringArray[i].length()];

            for (int i1 = 0; i1 < enteredNumbersStringArray[i].length(); i1++) {

                bytes[i1] = enteredNumbersStringArray[i].getBytes()[i1];
            }
            boolean hasOnlyEvenDigits = true;
            for (byte aByte : bytes) {
//                System.out.println(Integer.parseInt("" + (char) aByte));
                if (((Integer.parseInt("" + (char) aByte)) % 2) == 1) {
                    hasOnlyEvenDigits = false;
                    break;
                }
            }
            if (hasOnlyEvenDigits) {
                numberOfOnlyEvenDigits++;
                onlyEvenDigits += enteredNumbersStringArray[i] + " ";
            }

            int countOfEvenDigits = 0;
            int countOfOddDigits = 0;

            for (byte aByte : bytes) {
                if (((Integer.parseInt("" + (char) aByte)) % 2) == 1) {
                    countOfOddDigits++;
                } else countOfEvenDigits++;
            }

            if (countOfEvenDigits == countOfOddDigits) {
                sameEvenOddDigitsAmount += enteredNumbersStringArray[i] + " ";
            }
        }

        if (onlyEvenDigits.length() > 0) {
            String evenNumbersStringArray[] = onlyEvenDigits.trim().split("\\s+");

            int evenNumbersIntegerArray[] = new int[evenNumbersStringArray.length];


            for (int i = 0; i < evenNumbersStringArray.length; i++) {
                evenNumbersIntegerArray[i] = Integer.parseInt(evenNumbersStringArray[i]);
            }
            System.out.println("количество чисел, содержащих только четные цифры: " + evenNumbersStringArray
                    .length + " : " + Arrays.toString(evenNumbersIntegerArray));
        } else {
            System.out.println("чисел, содержащих только четные цифры нет");
        }
        if (sameEvenOddDigitsAmount.length() > 0) {
            String sameEvenOddDigitsAmountStringArray[] = sameEvenOddDigitsAmount.trim().split("\\s+");
            int sameEvenOddDigitsAmountIntegerArray[] = new int[sameEvenOddDigitsAmountStringArray.length];

            for (int i = 0; i < sameEvenOddDigitsAmountStringArray.length; i++) {
                sameEvenOddDigitsAmountIntegerArray[i] = Integer.parseInt(sameEvenOddDigitsAmountStringArray[i]);
            }
            System.out.println("количество чисел с равным числом четных и нечетных цифр: "
                    + sameEvenOddDigitsAmountStringArray.length
                    + " : " + Arrays.toString(sameEvenOddDigitsAmountIntegerArray));
        } else {
            System.out.println("чисел с равным числом четных и нечетных цифр нет");
        }
        System.out.println();
        System.out.println("6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел" +
                " несколько, найти первое из них.");

        boolean increasingDigits = false;
        String increasingDigitsNumbers = "";
        int countOfIncreasingNumbers = 0;

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {

            byte bytes[] = new byte[enteredNumbersStringArray[i].length()];

            for (int i1 = 0; i1 < enteredNumbersStringArray[i].length(); i1++) {

                bytes[i1] = enteredNumbersStringArray[i].getBytes()[i1];
            }
            for (int i1 = 0; i1 < bytes.length - 1; i1++) {
                if ((Integer.parseInt("" + bytes[i1])) <= (Integer.parseInt("" + bytes[i1 + 1]))) {
                    increasingDigits = true;
                    continue;
                } else {
                    increasingDigits = false;
                    break;
                }
            }
            if (increasingDigits) {
                increasingDigitsNumbers += enteredNumbersStringArray[i];
                countOfIncreasingNumbers++;
                break;
            }
        }
        if (countOfIncreasingNumbers > 0) {
            System.out.println("число, цифры в котором идут в строгом порядке возрастания: " + increasingDigitsNumbers);
        } else {
            System.out.println("таких чисел нет");
        }
        System.out.println();

        System.out.println("7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти " +
                "первое из них.");

        String onlyDiffirentNumbers = "";
        boolean isOnlyDifferentDigits;

        for (int i = 0; i < enteredNumbersStringArray.length; i++) {

            isOnlyDifferentDigits = true;

            byte bytes[] = new byte[enteredNumbersStringArray[i].length()];

            for (int i1 = 0; i1 < enteredNumbersStringArray[i].length(); i1++) {

                bytes[i1] = enteredNumbersStringArray[i].getBytes()[i1];
            }


            for (int j = 0; j < 10; j++) {
                if (counterArray[i][j] >= 2) {
                    isOnlyDifferentDigits = false;
                    break;

                }

            }
            if (isOnlyDifferentDigits) {
                onlyDiffirentNumbers += enteredNumbersStringArray[i];
                break;
            }
        }

        System.out.println("число, состоящее только из различных цифр: " + onlyDiffirentNumbers);
        System.out.println();

        System.out.println("8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.");
        System.out.println("введите матрицу чисел NxN в одной строке с пробелами: ");
        String enteredMatrixString = "";
        enteredMatrixString = scanner.nextLine();
        int matrix[][] = getIntegerMatrix(enteredMatrixString);
        for (int i = 0; i < (int) (Math.sqrt(matrix.length)); i++) {
            for (int j = 0; j < (int) (Math.sqrt(matrix.length)); j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(matrix));


    }

    static int[][] getIntegerMatrix(String enteredString) {

        String enteredNumbersStringArray[] = enteredString.trim().split("\\s+");
//        double matrixSize = enteredNumbersStringArray.length;
        int matrixSize=(int)Math.sqrt(enteredNumbersStringArray.length);
        int matrix[][] = new int[matrixSize][matrixSize];

        int k = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(enteredNumbersStringArray[k]);
                k++;
                if (k > enteredNumbersStringArray.length) {
                    break;
                }
            }
        }
        return matrix;
    }
}
