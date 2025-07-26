package com.pattern;

import java.util.Scanner;

public class pattern38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the rows :");
		int n=scanner.nextInt();
		int space=n-1;
		char a=65;
		
		for(int i=1;i<=n;i++)
		{ 
			char b=a;
			for(int j=1;j<=space;j++)
				System.out.print("  ");
			for(int j=0;j<=i-1;j++) {
				System.out.print(b+" ");
				b--;
			}
			char c=66;
			for(int j=1;j<=i-1;j++)
			{
				System.out.print(c+" ");
				c++;
			}
			a+=1;
			space--;
			
			System.out.println();
		}
		scanner.close();
	}

}
