package strings;

import java.util.Scanner;

public class compareto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the string 1");
		String str1=scanner.next();
		System.out.println("enter the string 2");
		String str2=scanner.next();
		if(str1.compareTo(str2)==0)
			System.out.println("String are equal ");
		else 
			System.out.println("Strings are not equal ");
		System.out.println("-----------------------------------");
		System.out.println("enter the string 1");
		str1=scanner.next();
		System.out.println("enter the string 2");
		str2=scanner.next();
		if(str1.compareToIgnoreCase(str2)==0)System.out.println("strings are equal");
		else System.out.println("strings are not equal");
		scanner.close();
	}

}
