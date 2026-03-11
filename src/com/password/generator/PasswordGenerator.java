package com.password.generator;

import java.util.Scanner;

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
                System.out.println("Password generation feature coming soon...");
            }

            else if(choice == 2) {
                System.out.println("Password strength checker coming soon...");
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

    }
}