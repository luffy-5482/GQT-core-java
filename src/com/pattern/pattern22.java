package com.pattern;

import java.util.Scanner;

public class pattern22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the count: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Print dashes
            for (int j = 0; j < i; j++) {
                System.out.print("-\t");
            }
            // Print # symbols
            for (int j = i; j < n; j++) {
                System.out.print("#\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
