package strings;

import java.util.Scanner;

public class reversestringwordwise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = scanner.nextLine();

        String temp_str = "";
        String final_str = "";

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch != ' ') {
                temp_str = ch + temp_str; // build the reversed word
            } else {
                final_str += temp_str + " "; // add the reversed word to final string
                temp_str = ""; // reset for next word
            }
        }

        // add the last word (since it may not end with space)
        final_str += temp_str;

        System.out.println(final_str);
        scanner.close();
    }
}
