package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int n;
        System.out.print("Enter the n (amount of numbers): ");
        Scanner in = new Scanner( System.in );
        n = in.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        int b[] = new int[n];
        for (int i = 0; i < n; i++){
            b[i] = Math.abs(array[i]);
        }
    int short_number, long_number, length_short_number = 1, length_long_number = 1, a = 10;
    short_number = b[0];
    long_number = b[0];
    int index_sh_n = 0, index_l_n = 0;
        for (int i = 1; i < n; i++){
            if (short_number > b[i]) {
                short_number = b[i];
                index_sh_n = i;
            }
            if (long_number < b[i]) {
                long_number = b[i];
                index_l_n = i;
            }
        }
        short_number = array[index_sh_n];
        long_number = array[index_l_n];
        while (short_number/a != 0) {
            length_short_number = length_short_number + 1;
            a = a *10;
        }
        a = 10;
        while (long_number/a != 0) {
            length_long_number = length_long_number + 1;
            a = a *10;
        }
        System.out.println("The shortest number: " + short_number + ", its length: " + length_short_number);
        System.out.println("The longest number: " + long_number + ", its length: " + length_long_number);
        int length = 1, sort;
        int new_a[] = new int[100], sort_new_a [] = new int[100], count[] = new int[n];
        a = 10;
        for (int i = 0; i < n; i++) {
            while (array[i] / a != 0) {
                length = length + 1;
                a = a * 10;
            }
            for (int j = 0; j < length; j++) {
                new_a[j] = Math.abs((int) (array[i] / Math.pow(10, j) % 10));
                sort_new_a[j] = new_a[j];
            }
            for (int j = 0; j < length - 1; j++) {
                for (int s = 0; s < length - 1; s++) {
                    if (sort_new_a[s + 1] > sort_new_a[s]) {
                        sort = sort_new_a[s + 1];
                        sort_new_a[s + 1] = sort_new_a[s];
                        sort_new_a[s] = sort;
                    }
                }
            }
            count[i] = length;
            for (int j = 0; j < length - 1; j++){
                if (sort_new_a[j] == sort_new_a[j+1]){
                    count[i] = count[i] - 1;
                }
            }
            length = 1; a = 10;
        }
        int min = count[0], digits_min_index = 0;
        for (int i = 1; i < n; i++){
            if (count[i] < min) {
                min = count[i];
                digits_min_index = i;
            }
        }
        System.out.println("A number in which different digits is minimum: " + array[digits_min_index]);
        int number_ascending = 0, dow4 = 0;
        for (int i = 0; i < n; i++) {
            while (array[i] / a != 0) {
                length = length + 1;
                a = a * 10;
            }
            for (int j = 0; j < length; j++) {
                new_a[j] = Math.abs((int) (array[i] / Math.pow(10, j) % 10));
                sort_new_a[j] = new_a[j];
            }
            for (int j = 0; j < length - 1; j++) {
                for (int s = 0; s < length - 1; s++) {
                    if (sort_new_a[s + 1] > sort_new_a[s]) {
                        sort = sort_new_a[s + 1];
                        sort_new_a[s + 1] = sort_new_a[s];
                        sort_new_a[s] = sort;
                    }
                }
            }
            for (int j = 0; j < length - 1; j++) {
                for (int s = 0; s < length - 1; s++) {
                    if (dow4 == 0 || dow4 == -1) {
                        if (new_a[j] == sort_new_a[j] && new_a[j + 1] == sort_new_a[j + 1]) {
                            if (sort_new_a[j+1] < sort_new_a[j]) {
                                number_ascending = array[i];
                                dow4 = 1;
                            }
                        } else dow4 = -1;
                    }
                }
            }
            length = 1; a = 10;
        }
        if (number_ascending != 0)
            System.out.println("A number, the numbers in which are in ascending order: " + number_ascending);
        else
            System.out.println("There is no number in which the digits are in ascending order");
        int dow5 = 0, different_digits = 0;
        for (int i = 0; i < n; i++) {
            while (array[i] / a != 0) {
                length = length + 1;
                a = a * 10;
            }
            for (int j = 0; j < length; j++) {
                new_a[j] = Math.abs((int) (array[i] / Math.pow(10, j) % 10));
                sort_new_a[j] = new_a[j];
            }
            for (int j = 0; j < length - 1; j++) {
                for (int s = 0; s < length - 1; s++) {
                    if (sort_new_a[s + 1] > sort_new_a[s]) {
                        sort = sort_new_a[s + 1];
                        sort_new_a[s + 1] = sort_new_a[s];
                        sort_new_a[s] = sort;
                    }
                }
            }
            for (int j = 0; j < length - 1; j++) {
                if (sort_new_a[j] == sort_new_a[j+1]){
                    different_digits = 0;
                    dow5 = -1;
                }
                else if (sort_new_a[j] != sort_new_a[j+1]){
                    different_digits = array[i];
                    dow5 = 1;}
                if (dow5 == -1) {
                    break;}
            }
            if (different_digits != 0){
                break;
            }
            length = 1; a = 10;
        }
        if (different_digits != 0)
            System.out.println("Number with different digits: " + different_digits);
        else if (different_digits == 0)
            System.out.println("There is no number in which the digits are different");
    }
}
