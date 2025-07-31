package arrays;

import java.util.Scanner;

public class totalduplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            int dup = 0;
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    visited[j] = true;
                    dup = 1;
                }
            }
            if(dup == 1) {
                count++;
            }
        }

        System.out.println("Total number of duplicate elements = " + count);
    }
}
