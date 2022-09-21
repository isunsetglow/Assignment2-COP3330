/*
 * Maria Hernandez
 * Assignment 2
 * COP3330
 * Sep 18th, 2022
 */

import java.util.Scanner;

public class Bank {
    private static Scanner scan = new Scanner(System.in);
    // private static array, size 5
    private static Account[] myAcc = new Account[5];

    // main method
    public static void main(String[] args) {
        int menu = 0;
        System.out.println("Welcome to Knightro Banking:");

        accMenu(menu);

        scan.close();
    }

    public static void accMenu(int accNum) {
        
        String name;
        double rate;

        while (accNum < 6) {
            
            for (int i = 0; i < myAcc.length; i++) {
                System.out.print((i + 1) + ". ");
                if (myAcc[i] == null) {
                    System.out.println("Empty");
                } else {
                    System.out.println(myAcc[i].getName());
                }
            }
            System.out.println("6. Exit Program");
            System.out.println("What would you like to do? ");
            accNum = scan.nextInt();

            if (accNum == 6) {
                System.out.println("Goodbye!");
                scan.close();
                System.exit(0);
            }

            if (myAcc[accNum - 1] == null) {
                System.out.println("Creating a new accout");
                System.out.println("What is the name of the account: ");
                name = scan.next();
                System.out.println("What is the interest rate?");
                rate = scan.nextDouble();
                myAcc[accNum - 1] = new Account(name, rate);
            } else {
                
                bankMenu(accNum);
            }
           
        }
        // scan.close(); 
    }

    // String name, double rate
    // String[] myArr, double[] myDoub
    public static void bankMenu(int accNum) {
        // Scanner scan = new Scanner(System.in);
        int months;
        double funds;
        // double intRate;
        // String accName;
        int userInput = 0;

        while (userInput < 5) {
            System.out.println("1. Deposit funds");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Check Balance");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Delete Account");
            System.out.println("What would you like to do?");

            userInput = scan.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("How much would you like to deposit?");
                    funds = scan.nextInt();
                    if (myAcc[accNum - 1].deposit(funds) == false) {
                        System.out.println("This is an invalid amount.");
                    } else {
                        System.out.println("You have added $" + funds);
                    }
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw?");
                    funds = scan.nextInt();
                    if (myAcc[accNum - 1].withdraw(funds) == false) {
                        System.out.println("This is an invalid amount.");
                    } else {
                        System.out.println("You have withdrawn $" + funds);
                    }
                    break;
                case 3:
                    System.out.println("You have " + myAcc[accNum - 1].getBalance());
                    break;
                case 4:
                    System.out.println("How many months have passed?");
                    months = scan.nextInt();
                    myAcc[accNum - 1].calcInterest(months);
                    System.out.println("Done");
                    break;
                case 5:
                    myAcc[accNum - 1] = null;
                    System.out.println("Account closed.");
                    break;
                default:
                    break;
            }
        }
        // scan.close();
    }
}