package arrays;

import java.util.Scanner;

public class sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Ascending order:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nDescending order:");
        for(int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
