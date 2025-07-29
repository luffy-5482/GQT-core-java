package com.pattern;

import java.util.Scanner;

public class pattern20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the count: ");
		int n=sc.nextInt();
		for(int i=0;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				System.out.print("_ ");
			for(int j=1;j<=n;j++)
				System.out.print("@ ");
			System.out.println();
		}
		sc.close();
	}

}
