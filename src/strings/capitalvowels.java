package strings;

import java.util.Scanner;

public class capitalvowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the string :");
		String str=scanner.nextLine();
		int smallervowels=0;
		int capitalvowels=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z' || str.charAt(i)>='a' && str.charAt(i)<='z' ){
				if(str.charAt(i)=='A' ||str.charAt(i)=='E'||str.charAt(i)=='I' ||str.charAt(i)=='O'||str.charAt(i)=='U') 
				{
					capitalvowels++;
				}
				if(str.charAt(i)=='a' ||str.charAt(i)=='e'||str.charAt(i)=='i' ||str.charAt(i)=='o'||str.charAt(i)=='u') {
					smallervowels++;
				}
			}
		}
		System.out.println("the smaller vowel count is :"+smallervowels);
		System.out.println("the uppercase vowel count is :"+capitalvowels);
		scanner.close();
	}
}
