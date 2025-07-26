package com.pattern;

import java.util.Scanner;

public class pattern25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the rows :");
		int n=scanner.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(j%2==0)
				System.out.print("0 ");
				else
					System.out.print("1 ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
