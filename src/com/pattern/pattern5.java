package com.pattern;

import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.print("enter the count: ");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.println(i+" ");
		}
		sc.close();
	}

}
