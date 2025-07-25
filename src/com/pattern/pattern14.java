package com.pattern;

import java.util.Scanner;

public class pattern14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.print("enter the count: ");//telling the user what to do 
		int n=sc.nextInt();//taking the input from the user 
		for(int i=1;i<=n;i++)//rows
		{
			for(int j=1;j<=i;j++)//coloumns
			{
				System.out.print("* ");//what to print 
			}
			System.out.println();//going to next line
		}
		sc.close();
	}

}
