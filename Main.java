package com.company;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
	String user_name;
	int number, sum = 0, product = 1;
        Scanner in = new Scanner( System.in );
        System.out.print("Please, enter your name: ");
        user_name = in.next();
        System.out.println("Good day, "+user_name+"! Can enter a sequence of integers. Enter 0 to complete.");
        while ( true ) {
            number = in.nextInt();
            sum = sum + number;
            if (number != 0) product = product * number;
            if (number == 0) break;
        }
        System.out.println("The sum of this sequence: " + sum);
        System.out.println("The product of this sequence: " + product);
    }
}
