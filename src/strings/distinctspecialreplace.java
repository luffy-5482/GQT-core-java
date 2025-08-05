package strings;

import java.util.Scanner;

public class distinctspecialreplace {
public static void main(String[] args) {
	Scanner scanner =new Scanner(System.in);
	System.out.print("enter the string :");
	String str=scanner.nextLine();
	String replaceString=str;
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)>='A' && str.charAt(i)<='Z' || str.charAt(i)>='a' && str.charAt(i)<='z' ) {
			if(str.charAt(i)=='a' || str.charAt(i)=='A')
			{
				replaceString=replaceString.replace(str.charAt(i), '$');
			}
			if(str.charAt(i)=='e' || str.charAt(i)=='E')
			{
				replaceString=replaceString.replace(str.charAt(i), '#');
			}
			if(str.charAt(i)=='i' || str.charAt(i)=='I')
			{
				replaceString=replaceString.replace(str.charAt(i), '*');
			}
			if(str.charAt(i)=='o' || str.charAt(i)=='O')
			{
				replaceString=replaceString.replace(str.charAt(i), '@');
			}
			if(str.charAt(i)=='u' || str.charAt(i)=='U')
			{
				replaceString=replaceString.replace(str.charAt(i), '&');
			}
		}
	}
	System.out.println("the replaced string is "+ replaceString);
	scanner.close();
}
}
