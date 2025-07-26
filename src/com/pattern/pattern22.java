package com.pattern;
//
//import java.util.Scanner;
//
//public class pattern22 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the count: ");
//        int n = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print("-\t");
//            }
//            for (int j = i; j < n; j++) {
//                System.out.print("#\t");
//            }
//            System.out.println();
//        }
//        sc.close();
//    }
//}
import java.util.Scanner;
public class pattern22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the rows");
        int n=sc.nextInt();
        int num=n;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            System.out.print("-"+"\t");
            for(int j=num;j>=1;j--)
            System.out.print("*"+"\t");
            num--;
            System.out.println();
        }
        sc.close();
    }
    
}
