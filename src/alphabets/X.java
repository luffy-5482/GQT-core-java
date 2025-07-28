package alphabets;

import java.util.Scanner;

public class X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the rows: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
	        {    
				if(i+j==n-1 || i==j)
	            System.out.print("* ");
				else {
					System.out.print("  ");
				}
	        }
			
	            System.out.println();
			}
			sc.close();
	}

}
