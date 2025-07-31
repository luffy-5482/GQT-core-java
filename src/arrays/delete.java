package arrays;
import java.util.Scanner;

public class delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to delete: ");
        int elem = sc.nextInt();
        int index = -1;

        for(int i = 0; i < n; i++) {
            if(arr[i] == elem) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            System.out.println("Element not found.");
        } else {
            for(int i = index; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }

            System.out.println("Array after deletion:");
            for(int i = 0; i < n - 1; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
