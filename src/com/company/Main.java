package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        int numPlayers = 0;
        int atBat = 0;
        double sum = 0.0;
        double baseAvg = 0.0;
        double count = 0.0;
        char temp = ' ';
        char yesNo = ' ';


        System.out.println("Welcome to the Batting Average Calculator!");

        System.out.println("How many players on your team?: ");
        numPlayers = getValidInteger();// scan1.nextInt();

        int[][] playerInfo = new int[numPlayers][];

        do {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Enter number of times at bat for Player " + (i + 1) + ": ");
                atBat = getValidInteger();//scan1.nextInt();
                scan1.nextLine();
                playerInfo[i] = new int[atBat];

                for (int j = 0; j < atBat; j++) {
                    System.out.println("Enter results for each at bat: (0= Out, 1= Single, 2= Double, 3= Triple, 4= Home Run):");
                    playerInfo[i][j] = getValidInteger(-1,5);//scan1.nextInt();

                }
            }
                for (int i = 0; i < playerInfo.length; i++) {
                    for (int j = 0; j < playerInfo[i].length; j++) { //calculates average bases per at bat
                        sum = sum + playerInfo[i][j];

                    }
                    baseAvg = sum / playerInfo[i].length;
                    System.out.println("Player " + (i + 1) + " Slugging Percentage: " + baseAvg);
                    sum = 0;

                }
                for (int i = 0; i < playerInfo.length; i++) {
                    for (int j = 0; j < playerInfo[i].length; j++) { //loop counts base hits (non-zero)
                        if (playerInfo[i][j] != 0) {
                            ++count;
                        }
                    }
                    double battingAvg = count / playerInfo[i].length; //playerInfo[i].length equals number of at bats
                    System.out.println("Player " + (i + 1) + " Batting Average: " + battingAvg);
                    count =0;
                }



            System.out.println("Another Team? (y/n):");
            yesNo = scan1.nextLine().charAt(0);
            temp = Character.toLowerCase(yesNo);


        } while (temp != 'n');
    }
    public static int getValidInteger() {
        Scanner scan1 = new Scanner(System.in);
        //validation for numbers
        while (!scan1.hasNextInt()) {
            scan1.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number
        }

        return scan1.nextInt(); //takes the correct integer

    }

    public static boolean checkRange(int input, int min, int max) {

        if (input <= min || input >= max) {
            return false;
        }

        return true;
    }

    public static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();
        while (checkRange(userInput, min, max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }
}