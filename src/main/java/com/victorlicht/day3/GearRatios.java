package com.victorlicht.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GearRatios {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/com/victorlicht/day3/data_file");
        Scanner fileReader = new Scanner(file);
        int count = 0;
        while (fileReader.hasNextLine()) {
            fileReader.nextLine();
            count++;
        }
        System.out.println(count);
        while (fileReader.hasNextLine()) {
            String row = fileReader.nextLine();

            char[] charArray = row.toCharArray();
            char[][] charMatrix = new char[charArray.length][(int) file.length()];
            for (int i = 0; i < charArray.length; i++) {
                System.out.print(charArray[i] + " ");
            }
            System.out.println();
        }
    }
}
