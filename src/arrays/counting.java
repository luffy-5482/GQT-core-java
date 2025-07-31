package arrays;

import java.util.Scanner;

public class counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int pos = 0, neg = 0, zero = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > 0) {
                pos++;
            } else if(arr[i] < 0) {
                neg++;
            } else {
                zero++;
            }
        }

        System.out.println("Positive: " + pos);
        System.out.println("Negative: " + neg);
        System.out.println("Zero: " + zero);
    }
}
