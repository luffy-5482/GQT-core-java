/**
 * 
 */
package com.pattern;

/*
# # # # # 
# - - - # 
# - - - # 
# - - - # 
# # # # # 

 */
import java.util.Scanner;

/**
 * @author tayyab sirkazi
 * @category patterns
 */
public class pattern40 {

	/**
	 * @description program for pattern
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the rows: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 || i==(n-1) ||j==0||j==(n-1))
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
