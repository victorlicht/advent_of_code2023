package com.victorlicht.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) {
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
}
