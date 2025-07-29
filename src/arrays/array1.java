package arrays;
import java.util.Scanner;

public class array1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("enter the student count: ");
		int n=scanner.nextInt(); 
		int arr[]=new int[n];
	
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("enter the element of the array no:"+(i+1));
			arr[i]=scanner.nextInt();
		}
		System.out.println("--------------------");
		
		for(int i=0;i<arr.length;i++)
			System.out.println("the marks of the student with the numeber "+(i+1)+"is :"+arr[i]);
		scanner.close();
	}

}
