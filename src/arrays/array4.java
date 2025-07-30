package arrays;

import java.util.Scanner;
class arrayoperation2{
	String arr[][];
	Scanner scanner=new Scanner(System.in);
void createarray() {
	System.out.print("enter the class count :");
	int cls=scanner.nextInt();
	arr=new String[cls][];
	for(int i=0;i<arr.length;i++) {
		System.out.println("enter the count of the student inside the class :"+(i+1));
		arr[i]=new String[scanner.nextInt()];
	}
	System.out.println("----------------array created-----------------");
}
void collectdata() {

	for(int i=0;i<arr.length;i++)
	{
		System.out.println("enter the students in the class: "+ (i+1));
		for(int j=0;j<arr[i].length;j++)
		{
		
		System.out.print("enter the name of the student no"+(j+1)+": ");
		arr[i][j]=scanner.next();
		}
	}
	System.out.println("-------------data stored-----------------");
}
void displaydata() {
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
		System.out.println("the marks of the student no"+(j+1)+": "+arr[i][j]);
		
		}
	}
}
}
public class array4{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
		arrayoperation2 ao=new arrayoperation2();
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