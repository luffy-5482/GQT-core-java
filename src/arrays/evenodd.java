package arrays;

import java.util.Scanner;

public class evenodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] even = new int[n];
        int[] odd = new int[n];
        int e = 0, o = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] % 2 == 0) {
                even[e++] = arr[i];
            } else {
                odd[o++] = arr[i];
            }
        }

        System.out.println("Even elements:");
        for(int i = 0; i < e; i++) {
            System.out.print(even[i] + " ");
        }

        System.out.println("\nOdd elements:");
        for(int i = 0; i < o; i++) {
            System.out.print(odd[i] + " ");
        }
    }
}
