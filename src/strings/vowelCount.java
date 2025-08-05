package strings;

import java.util.Scanner;

public class vowelCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the string :");
		String str=scanner.nextLine();
		int vowelcount=0;
		int cons_count=0;
		str=str.toUpperCase();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
				if(str.charAt(i)=='A' ||str.charAt(i)=='E'||str.charAt(i)=='I' ||str.charAt(i)=='O'||str.charAt(i)=='U')
					vowelcount++;
				else {
					cons_count++;
				}
			}
		}
		System.out.println("the vowels in the given string is :"+vowelcount);
		System.out.println("the consonants in the given string is :"+cons_count);
		scanner.close();
	}
}
