package arrays;
import java.util.Scanner;

public class specificposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to insert: ");
        int elem = sc.nextInt();
        System.out.print("Enter position (0 to " + n + "): ");
        int pos = sc.nextInt();

        for(int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = elem;

        System.out.println("Array after insertion:");
        for(int i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
