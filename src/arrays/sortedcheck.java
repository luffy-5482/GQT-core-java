package arrays;

import java.util.Scanner;

public class sortedcheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean isSorted = true;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }

        if(isSorted) {
            System.out.println("Array is sorted in ascending order.");
        } else {
            System.out.println("Array is not sorted.");
        }
    }
}
