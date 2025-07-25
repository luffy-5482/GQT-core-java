package com.pattern;

import java.util.Scanner;

public class Pattern13A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size : ");
		int n = scanner.nextInt();
		int count;
		for(int i=1;i<=n;i++) {
			count=i;
			for(int j=1;j<=n;j++) {
				System.out.print(count+"	");
				count=count+n;
			}
			System.out.println();
		}
	}
}
