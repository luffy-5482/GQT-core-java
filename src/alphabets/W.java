package alphabets;

import java.util.Scanner;

public class W {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the rows: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
	        {    
				if(j==0||j==n-1 ||i+j==n-1 && j<=n/2 || i==j&&j>=n/2)
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
