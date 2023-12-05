package com.victorlicht.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebuchet {


    public void partOne() {
        try {
            File file = new File("/home/vic/Desktop/Java/advent_of_code2023/src/main/java/com/victorlicht/day1/data_file");
            Scanner reader = new Scanner(file);
            int num, sum = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                int len = line.length(), leftNumber = Integer.MIN_VALUE, rightNumber = Integer.MAX_VALUE;
                int countL = 0;
                int countR = 0;
                for (int i = 0; i < len; i++) {
                    char l = line.charAt(i);
                    char r = line.charAt(len - 1);
                    if(Character.isDigit(l) && countL == 0) {
                        leftNumber = Character.getNumericValue(l);
                        countL ++;
                    }
                    if(Character.isDigit(r) && countR == 0) {
                        rightNumber = Character.getNumericValue(r);
                        countR ++;
                    }
                    if (countR == 0) {
                        len --;
                    }
                    if (countL != 0) {
                        i--;
                    }
                    if (countR != 0 && countL != 0) {
                        break;
                    }
                }
                if (rightNumber == Integer.MAX_VALUE) rightNumber = leftNumber;
                if (leftNumber == Integer.MIN_VALUE) leftNumber = rightNumber;
                System.out.println("line: " + line + "( " + leftNumber + ", " + rightNumber + " )");
                num = leftNumber * 10 + rightNumber;
                sum += num;
                System.out.println("Sum: " + sum);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int max(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = Integer.MIN_VALUE; // Initialize max with the first element of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            max = Math.max(max, arr[i]); // Update max if the current element is greater
        }
        return max;
    }

    public int min(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min = Integer.MAX_VALUE; // Initialize min with the first element of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            min = Math.min(min, arr[i]); // Update min if the current element is smaller
        }
        return min;
    }

    public void partTwo() {
        try {

            File file = new File("src/main/java/com/victorlicht/day1/data_file");
            Scanner reader = new Scanner(file);
            int num, sum = 0;
            while (reader.hasNextLine()) {
                final String ONE = "one", TWO = "two", THREE = "three", FOUR = "four", FIVE = "five", SIX = "six", SEVEN = "seven",
                        EIGHT = "eight", NINE = "nine";

                int oneIndex = -1, twoIndex = -1, threeIndex = -1, fourIndex = -1, fiveIndex = -1, sixIndex = -1,
                        sevenIndex = -1, eightIndex = -1, nineIndex = -1;

                int oneLastIndex = -1, twoLastIndex = -1, threeLastIndex = -1, fourLastIndex = -1, fiveLastIndex = -1, sixLastIndex = -1,
                        sevenLastIndex = -1, eightLastIndex = -1, nineLastIndex = -1;

                int maxWordIndex;
                int minWordIndex;
                int realLeftNumber;
                int realRightNumber;
                int[] indexArray;
                int[] indexArrayLast;

                String line = reader.nextLine();
                int len = line.length(),
                        leftNumber = Integer.MIN_VALUE,
                        rightNumber = Integer.MAX_VALUE,
                        indexL = 0,
                        indexR = 0,
                        countR = 0,
                        countL = 0;

                if (line.contains(ONE)) {
                    oneIndex = line.indexOf(ONE);
                    oneLastIndex = line.lastIndexOf(ONE);
                }
                if (line.contains(TWO)) {
                    twoIndex = line.indexOf(TWO);
                    twoLastIndex = line.lastIndexOf(TWO);
                }
                if (line.contains(THREE)) {
                    threeIndex = line.indexOf(THREE);
                    threeLastIndex = line.lastIndexOf(THREE);
                }
                if (line.contains(FOUR)) {
                    fourIndex = line.indexOf(FOUR);
                    fourLastIndex = line.lastIndexOf(FOUR);
                }
                if (line.contains(FIVE)) {
                    fiveIndex = line.indexOf(FIVE);
                    fiveLastIndex = line.lastIndexOf(FIVE);
                }
                if (line.contains(SIX)) {
                    sixIndex = line.indexOf(SIX);
                    sixLastIndex = line.lastIndexOf(SIX);
                }
                if (line.contains(SEVEN)) {
                    sevenIndex = line.indexOf(SEVEN);
                    sevenLastIndex = line.lastIndexOf(SEVEN);
                }
                if (line.contains(EIGHT)) {
                    eightIndex = line.indexOf(EIGHT);
                    eightLastIndex = line.lastIndexOf(EIGHT);
                }
                if (line.contains(NINE)) {
                    nineIndex = line.indexOf(NINE);
                    nineLastIndex = line.lastIndexOf(NINE);
                }

                indexArray = new int[]{oneIndex, twoIndex, threeIndex, fourIndex,
                        fiveIndex, sixIndex, sevenIndex, eightIndex, nineIndex};
                indexArrayLast = new int[]{oneLastIndex, twoLastIndex, threeLastIndex,
                        fourLastIndex, fiveLastIndex, sixLastIndex, sevenLastIndex,
                        eightLastIndex, nineLastIndex};

                maxWordIndex = max(indexArrayLast);
                minWordIndex = min(indexArray);
                for (int i = 0; i < len; i++) {
                    char l = line.charAt(i);
                    char r = line.charAt(len - 1);

                    if(Character.isDigit(l) && countL == 0) {
                        leftNumber = Character.getNumericValue(l);
                        indexL = i;
                        countL ++;
                    }
                    if(Character.isDigit(r) && countR == 0) {
                        rightNumber = Character.getNumericValue(r);
                        indexR = len - 1;
                        countR ++;
                    }
                    if (countR == 0) {
                        len --;
                    }
                    if (countL != 0) {
                        i--;
                    }
                    if (countR != 0 && countL != 0) {
                        break;
                    }
                }
                if (rightNumber == Integer.MAX_VALUE) {
                    rightNumber = leftNumber;
                    indexR = indexL;
                }
                if (leftNumber == Integer.MIN_VALUE) {
                    leftNumber = rightNumber;
                    indexL = indexR;
                }
                if (indexL > minWordIndex) {
                    int numm = 1;
                    for (int i = 1; i < indexArray.length ; i++) {
                        if (indexArray[i] == minWordIndex) {
                            numm += i;
                            break;
                        }
                    }
                    realLeftNumber = numm;
                }else {
                    realLeftNumber = leftNumber;
                }
                if (indexR < maxWordIndex) {
                    int numm = 1;
                    for (int i = 1; i < indexArrayLast.length ; i++) {
                        if (indexArrayLast[i] == maxWordIndex) {
                            numm += i;
                            break;
                        }
                    }
                    realRightNumber = numm;
                }else {
                    realRightNumber = rightNumber;
                }
                System.out.println("line: " + line + "( " + realLeftNumber + ", " + realRightNumber + " )");
                num = realLeftNumber * 10 + realRightNumber;
                sum += num;
                System.out.println("Sum: " + sum);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Trebuchet trebuchet = new Trebuchet();
        //trebuchet.partOne();
        trebuchet.partTwo();
    }
}
