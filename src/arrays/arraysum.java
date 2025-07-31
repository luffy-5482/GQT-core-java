package arrays;

import java.util.Scanner;

public class arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        // Sum calculation
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Output
        System.out.println("Sum of all elements = " + sum);
        sc.close();
    }
}

