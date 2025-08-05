package strings;

public class built_in_class {
	public static void main(String args[]) {
		String str = "SachinRameshTendulkar";
		//1.length()
		int length = str.length();
		System.out.println("the length of the string is "+length);
		
		//2.charAt()
		char c = str.charAt(0);
		System.out.println(c);
		
		//3.concat()
		String str1=str.concat(str);
		System.out.println(str1);
		
		//4. contains()
		boolean res1=str.contains("Ramesh");
		System.out.println(res1);
		res1=str.contains("Umesh");
		System.out.println(res1);
		
		//5.endswith
		boolean res2= str.endsWith("Tendulkar");
		System.out.println(res2);
		res2=str.endsWith("pendulkar");
		System.out.println(res2);
		
		//6.startswith
		boolean res3= str.startsWith("Tendulkar");
		System.out.println(res3);
		res2=str.startsWith("pendulkar");
		System.out.println(res3);
		
		//7.getClass()
		Class class1=str.getClass();//this will return from which class this particular string belongs to 
		System.out.println(class1);
		
		//8. Hascode 
		int hascode=str.hashCode();//every string is assigned one hash code as it is converted to the object it will return that particular hascode
		System.out.println(hascode);
		
		//9.indexOf()
		int index1=str.indexOf('S');
		System.out.println(index1);
		index1=str.indexOf('Z');
		System.out.println(index1);
		
		//10.isBlank()	
		boolean res4=str.isBlank();
		System.out.println(res4);
		String str2="               ";
		res4=str2.isBlank();
		System.out.println(res4);
		String str3="";
		res4=str3.isBlank();
		System.out.println(res4);
		
		//11. isEmpty()
		boolean res5=str.isEmpty();
		System.out.println(res5);
		String str4="               ";
		res5=str4.isEmpty();
		System.out.println(res5);
		String str5="";
		res5=str5.isEmpty();
		System.out.println(res5);
		
		//12.lastIndexOf()
		int lastIndex=str.lastIndexOf('e');//if the string contains multiple same charechter then this will return the last occurrence of the given charechter
		System.out.println(lastIndex);
		lastIndex=str.lastIndexOf('z');//if the string contains multiple same charechter then this will return the last occurrence of the given charechter
		System.out.println(lastIndex);
		
		//13.replace()
		String replace=str.replace('S', '$');
		System.out.println(replace);
		
		//14.substring(int start)
		String subString=str.substring(6);
		System.out.println(subString);
		
		//15.substring(int start,int end)
		subString=str.substring(6,12);
		System.out.println(subString);
		
		//16.toUpperCase()
		String touppercaseString=str.toUpperCase();
		System.out.println(touppercaseString);
		
		//17.tolowerCase()
		String tolowerString=str.toLowerCase();
		System.out.println(tolowerString);
	}
}
