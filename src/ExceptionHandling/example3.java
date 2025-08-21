package ExceptionHandling;

import java.util.Scanner;
//problem with one catch block
public class example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the first number");
			int n1=sc.nextInt();
			System.out.println("enter the second number");
			int n2=sc.nextInt();
			int res=n1/n2;
			System.out.println(res);
			
			System.out.println("---------------------");
			System.out.println("Array operation");
			System.out.println("enter the size of the array :");
			int size=sc.nextInt();
			int arr[]=new int[size];
			System.out.println("enter the value to enter");
			int val=sc.nextInt();
			System.out.println("enter the position to enter");
			int pos=sc.nextInt();
			arr[pos]=val;
			sc.close();
			}
			catch(Exception e){
				System.out.println("the exception was handled");
			}
	}

}
