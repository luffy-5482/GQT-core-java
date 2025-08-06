package quiz;

public class mutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str1= new StringBuffer("Ramayana");
		StringBuffer str2= new StringBuffer(" is the best mythological story");
		System.out.println(str1.append(str2));
		System.out.println("---------------------------");
		StringBuilder str3= new StringBuilder("Mahabharatha");
		StringBuilder str4= new StringBuilder(" is the best mythological history");
		System.out.println(str3.append(str4));
		
	}

}
