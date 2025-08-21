package ExceptionHandling;
import java.util.Scanner;

public class example4 {

	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number :");
		int n1 = sc.nextInt();// critical statement -- InputMismatchException
		System.out.println("Enter the second number :");
		int n2 = sc.nextInt();// critical statement -- InputMismatchException
		
		int res = n1 / n2;
		System.out.println(res);
		System.out.println("---------------");
		System.out.println("Array operation");
		System.out.println("Enter the array size :");
		int size = sc.nextInt();// critical statement -- InputMismatchException
		int arr[] = new int[size];
		System.out.println("Enter the value to be added");
		int val = sc.nextInt();// critical statement -- InputMismatchException
		System.out.println("Enter the position into which value has to be added ");
		int pos = sc.nextInt();// critical statement -- InputMismatchException
		arr[pos] = val;
		System.out.println("value added ");
    }
		// specific multi-catch 
		catch(ArithmeticException ae) {
			System.out.println("Arithmetic Exception was generated and handled or "
					+ "Input Mismatch Exception was generated and handled");
		}
		catch(NegativeArraySizeException nae) {
			System.out.println(" NegativeArraySize Exception was generated and handled or "
					+ "ArrayIndexOutOfBound Exception was generated and handled");
		}
		catch (Exception e) {
			System.out.println("Exception Occured and handed in catch block");
		}
		}

}