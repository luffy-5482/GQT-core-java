/**
 * 
 */
package com.pattern;

import java.util.Scanner;
/*
 * #
 * # #
 * # - #
 * # - - #
 * # # # # #
 */
/**
 * @author tayyab sirkazi
 */
public class pattern41 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the rows: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(i==0 || i==(n-1) ||j==0||j==i)
					System.out.print("# ");
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
