package arrays;

import java.util.Scanner;
class arrayoperations{
	int arr[];
	Scanner scanner=new Scanner(System.in);
	void createarray() {
		System.out.print("enter the student count: ");
		int n=scanner.nextInt(); 
		arr=new int[n];
		System.out.println("----------------array created-----------------");
	}
	void collectdata() {

		for(int i=0;i<arr.length;i++)
		{
			System.out.print("enter the marks of the student no"+(i+1)+": ");
			arr[i]=scanner.nextInt();
		}
		System.out.println("-------------data stored-----------------");
	}
	void displaydata() {
		for(int i=0;i<arr.length;i++)
			System.out.println("the marks of the student with the numeber "+(i+1)+" is :"+arr[i]);
	}
}
public class array2 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
		arrayoperations ao=new arrayoperations();
		while (true) {
		System.out.println("enter the operation you want to perform: ");
		System.out.println("1.create 2.collectdata 3.display 4.exit");
		int n=scanner.nextInt();
		switch(n) {
		case 1:
			ao.createarray();
			break;
		
		case 2:
			ao.collectdata();
			break;
		
		case 3:
			ao.displaydata();
			break;
			
		case 4:
			scanner.close();
			return ;
		
			default:
				System.out.println("enter the correct input");
			
		}
		
		}
	}

}
