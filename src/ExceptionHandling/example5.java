package ExceptionHandling;
import java.util.Scanner;
// try with single catch block
  
public class example5{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
		// TODO Auto-generated method stub
		System.out.println("Division Operation");	
		System.out.println("Enter the first number :");
		int n1 = sc.nextInt();// critical statement -- InputMismatchException
		System.out.println("Enter the second number :");
		int n2 = sc.nextInt();// critical statement -- InputMismatchException
		
		int res = n1 / n2;//critical statement -- ArithmeticException
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
		catch (Exception ae) {
			System.out.println("Arthmetic Exception Occured and handed in catch block");
		}
		finally {
			sc.close();
			System.out.println("Scanner is closed");
		}
		}

}