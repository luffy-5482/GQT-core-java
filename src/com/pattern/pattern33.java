package com.pattern;

import java.util.Scanner;

public class pattern33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the rows :");
		int n=scanner.nextInt();
		int space=n-1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=space;j++)
				System.out.print("\t");
			for(int j=1;j<=i;j++)
			{
				
				System.out.print("*\t\t");
			}
			space--;
			System.out.println();
		}
		scanner.close();
	}

}
