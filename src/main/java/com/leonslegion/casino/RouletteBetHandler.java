package com.leonslegion.casino;

import java.util.*;

import org.apache.commons.lang3.math.NumberUtils;

public class RouletteBetHandler {



    public static String handleAnyBet() {
        String bet = InputHandler.getStringInput("Pick a bet to make by typing 'inside' or 'outside'.");
        if (bet.equalsIgnoreCase("inside")) {
            return handleInsideBet();
        }
        else if (bet.equalsIgnoreCase("outside")) {
            return handleOutsideBet();
        }
        else {
            return handleAnyBet();
        }
    }



    private static String handleInsideBet() {
        String bet = InputHandler.getStringInput("Enter which number you'd like to bet on.");
        if (NumberUtils.isParsable(bet)) {
            if (Integer.parseInt(bet) < 0 || Integer.parseInt(bet) > 36) {
                System.out.println("Bet not accepted.");
                System.out.println();
                return handleInsideBet();
            } else {
                System.out.println("Bet accepted.");
                System.out.println();
                return bet;
            }
        }
        else {
            System.out.println("Bet must be a number!");
            return handleInsideBet();}
    }




    private static String handleOutsideBet() {
        System.out.println("Which outside bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from 'Column', 'Dozen', 'Even Or Odd', 'Front or Back', or 'Color'.");
        if (bet.equalsIgnoreCase("Column")) {
            return handleColumnBet();
        }
        else if (bet.equalsIgnoreCase("Dozen")) {
            return handleDozenBet();
        }
        else if (bet.equalsIgnoreCase("Even or Odd")) {
            return handleEvenOrOddBet();
        }
        else if (bet.equalsIgnoreCase("Front or Back")) {
            return handleFrontOrBackBet();
        }
        else if (bet.equalsIgnoreCase("Color")) {
            return handleColorBet();
        }
        else {
            return handleOutsideBet();
        }
    }



    private static String handleColumnBet() {
        System.out.println("Which column bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from '1st C', '2nd C', or '3rd C'.");
        if (bet.equals("1st C") || bet.equals("2nd C") || bet.equals("3rd C")) {
            return bet;
        }
        else {return handleColumnBet();}
    }



    private static String handleDozenBet() {
        System.out.println("Which dozen bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from '1st D', '2nd D', or '3rd D'.");
        if (!bet.equals("1st D") && !bet.equals("2nd D") && !bet.equals("3rd D")) {
            return handleDozenBet();
        }
        else {return bet;}
    }



    private static String handleEvenOrOddBet() {
        System.out.println("Which even or odd bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from 'Even', or 'Odd'.");
        if (!bet.equalsIgnoreCase("Even") && !bet.equalsIgnoreCase("Odd")) {
            return handleEvenOrOddBet();
        }
        else {return bet.toLowerCase();}
    }



    private static String handleFrontOrBackBet() {
        System.out.println("Which front or back bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from 'Front', or 'Back'.");
        if (!bet.equalsIgnoreCase("Front") && !bet.equalsIgnoreCase("Back")) {
            return handleFrontOrBackBet();
        }
        else {return bet.toLowerCase();}
    }



    private static String handleColorBet() {
        System.out.println("Which color odd bet type would you like to make?");
        String bet = InputHandler.getStringInput("Select from 'Red', or 'Black'.");
        if (!bet.equalsIgnoreCase("Red") && !bet.equalsIgnoreCase("Black")) {
            return handleColorBet();
        }
        else {return bet.toLowerCase();}
    }



    public static void checkPlayerBetsForInsideBetWins(RoulettePlayer player, String spinResult) {
        for (RouletteBet bet : player.getBetList()) {
            if (bet.getBetType().equals(spinResult)) {
                System.out.print("You won a 35:1 Payout! You won: $");
                System.out.printf("%,.2f", bet.getBetValue() * 34);
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue() * 35));
                break;
            }
        }
    }



    public static void checkPlayerBetsForOutsideDozenBetWins(RoulettePlayer player, String spinResult) {
        for (RouletteBet bet : player.getBetList()) {
            if (Integer.parseInt(spinResult) > 0 && Integer.parseInt(spinResult) < 13 && bet.getBetType().equals("1st D")) {
                System.out.print("You won a 2:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue()*2);
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*3));
            }
            if (Integer.parseInt(spinResult) > 12 && Integer.parseInt(spinResult) < 25 && bet.getBetType().equals("2nd D")) {
                System.out.print("You won a 2:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue()*2);
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*3));
            }
            if (Integer.parseInt(spinResult) > 24 && Integer.parseInt(spinResult) < 37 && bet.getBetType().equals("3rd D")) {
                System.out.print("You won a 2:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue()*2);
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*3));
            }
        }
    }



    public static void checkPlayerBetsForOutsideColumnBetWins(RoulettePlayer player, String spinResult) {
        for (RouletteBet bet : player.getBetList()) {
            for (int columnStart = 1; columnStart < 35; columnStart += 3) {
                if (Integer.parseInt(spinResult) == columnStart && bet.getBetType().equals("1st C")) {
                    System.out.print("You won a 2:1 Payout! You won: ");
                    System.out.printf("%,.2f", bet.getBetValue() * 2);
                    System.out.println();
                    player.setBalance(player.getBalance() + (bet.getBetValue() * 3));
                }
            }
            for (int columnStart = 2; columnStart < 36; columnStart += 3) {
                if (Integer.parseInt(spinResult) == columnStart && bet.getBetType().equals("2nd C")) {
                    System.out.print("You won a 2:1 Payout! You won: ");
                    System.out.printf("%,.2f", bet.getBetValue() * 2);
                    System.out.println();
                    player.setBalance(player.getBalance() + (bet.getBetValue() * 3));
                }
            }
            for (int columnStart = 3; columnStart < 37; columnStart += 3) {
                if (Integer.parseInt(spinResult) == columnStart && bet.getBetType().equals("3rd C")) {
                    System.out.print("You won a 2:1 Payout! You won: ");
                    System.out.printf("%,.2f", bet.getBetValue() * 2);
                    System.out.println();
                    player.setBalance(player.getBalance() + (bet.getBetValue() * 3));
                }
            }
        }
    }



    public static void checkPlayerBetsForEvenOrOddBetWins(RoulettePlayer player, String spinResult) {
        for (RouletteBet bet : player.getBetList()) {
            if (Integer.parseInt(spinResult) % 2 == 0 && Integer.parseInt(spinResult) != 0 && bet.getBetType().equals("Even")) {
                System.out.print("You won a 1:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue());
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*2));
            }
            if (Integer.parseInt(spinResult) % 2 == 1 && Integer.parseInt(spinResult) != 0 && bet.getBetType().equals("Odd")) {
                System.out.print("You won a 1:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue());
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*2));
            }
        }
    }



    public static void checkPlayerBetsForFrontOrBackBetWins(RoulettePlayer player, String spinResult) {
        for (RouletteBet bet : player.getBetList()) {
            if (Integer.parseInt(spinResult) > 0 && Integer.parseInt(spinResult) < 19 && bet.getBetType().equals("Front")) {
                System.out.print("You won a 1:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue());
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*2));
            }
            if (Integer.parseInt(spinResult) > 18 && Integer.parseInt(spinResult) < 37 && bet.getBetType().equals("Back")) {
                System.out.print("You won a 1:1 Payout! You won: ");
                System.out.printf("%,.2f", bet.getBetValue());
                System.out.println();
                player.setBalance(player.getBalance() + (bet.getBetValue()*2));
            }
        }
    }

    public static void checkPlayerBetsForColorBetWins(RoulettePlayer player, String spinResult) {
        int[] redList = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int[] blackList = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        for (RouletteBet bet : player.getBetList()) {
            if (bet.getBetType().equalsIgnoreCase("Red")) {
                for (int i = 0; i < redList.length; i++) {
                    if (Integer.parseInt(spinResult) == redList[i]) {
                        System.out.print("You won a 1:1 Payout! You won: ");
                        System.out.printf("%,.2f", bet.getBetValue());
                        System.out.println();
                        player.setBalance(player.getBalance() + (bet.getBetValue()*2));
                    }
                }
            }
            if (bet.getBetType().equalsIgnoreCase("Black")) {
                for (int i = 0; i < blackList.length; i++) {
                    if (Integer.parseInt(spinResult) == blackList[i]) {
                        System.out.print("You won a 1:1 Payout! You won: ");
                        System.out.printf("%,.2f", bet.getBetValue());
                        System.out.println();
                        player.setBalance(player.getBalance() + (bet.getBetValue()*2));
                    }
                }
            }
        }
    }




}
