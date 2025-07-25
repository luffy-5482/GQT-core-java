package com.pattern;

import java.util.Scanner;

public class pattern12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.print("enter the count: ");
		int n=sc.nextInt();
		int a=n*n;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(a+"\t");
				a--;
			}
			System.out.println();
		}
		sc.close();
	}

}
