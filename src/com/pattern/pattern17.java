package com.pattern;
import java.util.Scanner;
public class pattern17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.print("enter the count: ");
		int n=sc.nextInt();
		int num=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(num+"\t");
				num++;
			}
			System.out.println();
		}
		sc.close();
	}
}
