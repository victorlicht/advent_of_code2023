package com.victorlicht.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CubeConundrum {
    //TODO: Small bag and some cubes (green, red, blue)
    // He will hide a secret number of cubes of each color in the bag
    // Each game is listed with the ID number Game 11: ...; => ... = subset like (3green, 4red)
    // Game 1: set 1 = (3 blue, 4 red);
    //         set 2 = (1 red, 2 green, 6 blue);
    //         set 3 = (2 green) $
    // Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue $
    // Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
    // Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
    // Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green $
    //  only 12 red cubes, 13 green cubes, and 14 blue cubes

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/com/victorlicht/day2/data_file");
        final int GREEN_MAX = 13;
        final int BLUE_MAX = 14;
        final int RED_MAX = 12;
        boolean possible = true;
        int redSum = 0, blueSum = 0, greenSum = 0, gameSum = 0;
        int[] max = {-1, -1, -1};
        Scanner fileReader = new Scanner(file);
        int result = 0;
        int rowResult;
        int result2 = 0;
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(": ");
            String[] cubesParts = parts[1].split(";");
            max[0] = -1;
            max[1] = -1;
            max[2] = -1;
            possible = true;
            for (String cubePart : cubesParts) {
                String[] color = cubePart.split(",");

                for (String colorPart : color) {

                    if (colorPart.contains("red")) {
                        String redWord = colorPart.replace(" ", "");
                        char[] redWordCharArray = redWord.toCharArray();
                        int redNumber;
                        redSum = 0;
                        for (int i = 0; i < redWordCharArray.length; i++ ){
                            char l = redWordCharArray[i];
                            if (Character.isDigit(l)) {
                                redNumber = Integer.parseInt(String.valueOf(l));
                                redSum *= 10;
                                redSum += redNumber;
                                if (redSum > max[0]) {
                                    max[0] = redSum;
                                }
                            }

                        }
                        if (redSum > RED_MAX)
                            possible = false;
                    }
                    if (colorPart.contains("blue")) {
                        String blueWord = colorPart.replace(" ", "");
                        char[] blueWordCharArray = blueWord.toCharArray();
                        int blueNumber;
                        blueSum = 0;
                        for (int i = 0; i < blueWordCharArray.length; i++ ){
                            char l = blueWordCharArray[i];
                            if (Character.isDigit(l)) {
                                blueNumber = Integer.parseInt(String.valueOf(l));
                                blueSum *= 10;
                                blueSum += blueNumber;
                                if (blueSum > max[1]) {
                                    max[1] = blueSum;
                                }
                            }

                        }
                        if (blueSum > BLUE_MAX)
                            possible = false;
                    }
                    if (colorPart.contains("green")) {
                        String greenWord = colorPart.replace(" ", "");
                        char[] greenWordCharArray = greenWord.toCharArray();
                        int greenNumber;
                        greenSum = 0;
                        for (int i = 0; i < greenWordCharArray.length; i++ ){
                            char l = greenWordCharArray[i];
                            if (Character.isDigit(l)) {
                                greenNumber = Integer.parseInt(String.valueOf(l));
                                greenSum *= 10;
                                greenSum += greenNumber;
                            }
                            if (greenSum > max[2]) {
                                max[2] = greenSum;
                            }

                        }
                        if (greenSum > GREEN_MAX)
                            possible = false;
                    }
                }
            }
            System.out.print("red: " + max[0] + " ");
            System.out.print("blue: " + max[1]+ " ");
            System.out.println("grean: " + max[2]);

            rowResult = max[0] * max[1] * max[2];
            result2 += rowResult;
            if (possible) {
                String gameNumber = parts[0].replace(" ", "");
                char[] gameNumberArr = gameNumber.toCharArray();
                int gameNum;
                gameSum = 0;
                for (int i = 0; i < gameNumberArr.length; i++ ){
                    char l = gameNumberArr[i];
                    if (Character.isDigit(l)) {
                        gameNum = Integer.parseInt(String.valueOf(l));
                        gameSum *= 10;
                        gameSum += gameNum;
                    }

                }
                result += gameSum;

            }
        }
        System.out.println(result);
        System.out.println(result2);
    }
}