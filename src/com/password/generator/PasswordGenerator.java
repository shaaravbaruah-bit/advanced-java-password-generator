package com.password.generator;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("==== Password Generator Tool ====");
            System.out.println("1 Generate Password");
            System.out.println("2 Check Password Strength");
            System.out.println("3 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if(choice == 1) {

                System.out.print("Enter password length: ");
                int length = sc.nextInt();

                System.out.print("How many passwords generate: ");
                int count = sc.nextInt();

                System.out.print("Include uppercase letters? (y/n): ");
                char upper = sc.next().charAt(0);

                System.out.print("Include numbers? (y/n): ");
                char numbers = sc.next().charAt(0);

                System.out.print("Include symbols? (y/n): ");
                char symbols = sc.next().charAt(0);

                String chars = "abcdefghijklmnopqrstuvwxyz";

                if(upper == 'y') {
                    chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                }

                if(numbers == 'y') {
                    chars += "0123456789";
                }

                if(symbols == 'y') {
                    chars += "!@#$%&*";
                }

                try {

                    FileWriter writer = new FileWriter("passwords.txt", true);

                    for(int j = 1; j <= count; j++) {

                        String password = "";

                        for(int i = 0; i < length; i++) {

                            int index = (int)(Math.random() * chars.length());

                            password += chars.charAt(index);
                        }

                        System.out.println("Password " + j + ": " + password);

                        writer.write(password + "\n");
                    }

                    writer.close();

                    System.out.println("Passwords saved to passwords.txt");

                } catch(IOException e) {
                    System.out.println("Error saving passwords.");
                }
            }

            else if(choice == 2) {

                System.out.print("Enter password to check: ");
                String password = sc.next();

                int length = password.length();

                boolean hasUpper = false;
                boolean hasNumber = false;
                boolean hasSymbol = false;

                for(int i = 0; i < length; i++) {

                    char ch = password.charAt(i);

                    if(Character.isUpperCase(ch)) {
                        hasUpper = true;
                    }

                    else if(Character.isDigit(ch)) {
                        hasNumber = true;
                    }

                    else if(!Character.isLetterOrDigit(ch)) {
                        hasSymbol = true;
                    }
                }

                if(length >= 8 && hasUpper && hasNumber && hasSymbol) {
                    System.out.println("Password Strength: Strong");
                }

                else if(length >= 6) {
                    System.out.println("Password Strength: Medium");
                }

                else {
                    System.out.println("Password Strength: Weak");
                }
            }

            else if(choice == 3) {
                System.out.println("Program exited.");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }

            System.out.println();
        }

        sc.close();
    }
}