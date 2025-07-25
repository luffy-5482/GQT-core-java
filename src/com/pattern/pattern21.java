package com.pattern;

import java.util.Scanner;

public class pattern21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.print("enter the count: ");
		int n=sc.nextInt();
		int num=n;
		int s=1;
		for(int i=n;i>=1;i--)
		{
			for(int j=n;j>=1;j--)
			{
				System.out.print("-"+"\t");
			}
			for(int j=1;j<=s;j++)
			{
			System.out.print("# "+"\t");
			}
			s++;
			n--;
			System.out.println();
		}
		sc.close();
	}

}
