package com.pattern;
import java.util.Scanner;

public class pattern26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the rows :");
		int n=scanner.nextInt();
		int space=n-1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=space;j++)
				System.out.print("  ");
			for(int j=1;j<=i;j++)
				System.out.print(i+" ");
			for(int j=1;j<=i-1;j++)
				System.out.print(i+" ");
			space--;
			System.out.println();
		}
		scanner.close();
	}

}
