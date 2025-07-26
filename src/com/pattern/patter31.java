package com.pattern;

import java.util.Scanner;

public class patter31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the rows :");
		int n=scanner.nextInt();
		int space=n-1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.print("  ");
			for(int j=1;j<=space+1;j++)
				System.out.print((space+1)+" ");
			for(int j=1;j<=space;j++)
				System.out.print((space+1)+" ");
			space--;
			System.out.println();
		}
		int num=n-1;
		for(int i=1;i<=n-1;i++)
        {
           for(int j=1;j<=num;j++)
        	   System.out.print("  ");
           for(int j=1;j<=i+1;j++)
        	   System.out.print((i+1)+" ");
           for(int j=1;j<=i;j++)
        	   System.out.print((i+1)+" ");
            num--;
            System.out.println();
        }
		scanner.close();
	}

}
