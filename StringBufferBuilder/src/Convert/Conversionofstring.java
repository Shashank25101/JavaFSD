package Convert;

import java.util.Scanner;

public class Conversionofstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name ");
        String input = scanner.nextLine();
        String inputString =("Hello!"+' '+input);
        System.out.println(inputString);
        scanner.close();

        System.out.println("\nMethods of Strings: ");
        
        // Length of the string
        System.out.println(inputString.length());

        // Substring
        System.out.println(inputString.substring(2));

        // String Comparison
        String compareString = "Hello";
        System.out.println(inputString.compareTo(compareString));

        // IsEmpty
        System.out.println(inputString.isEmpty());

        // toLowerCase
        System.out.println(inputString.toLowerCase());

        // Replace
        String replaceString = inputString.replace('d', 'l');
        System.out.println(replaceString);

        // Equals
        String compareEquals = "Welcome to Java";
        System.out.println(inputString.equals(compareEquals));

        System.out.println("\nCreating StringBuffer: ");

        // Creating StringBuffer and append method
        StringBuffer stringBuffer = new StringBuffer(inputString);
        stringBuffer.append(" Enjoy your learning");
        System.out.println(stringBuffer);

        // Insert method
        stringBuffer.insert(0, 'w');
        System.out.println(stringBuffer);

        // Replace method
        StringBuffer replaceBuffer = new StringBuffer(inputString);
        replaceBuffer.replace(0, 2, "hEl");
        System.out.println(replaceBuffer);

        // Delete method
        StringBuffer deleteBuffer = new StringBuffer(inputString);
        deleteBuffer.delete(0, 1);
        System.out.println(deleteBuffer);

        System.out.println("\nCreating StringBuilder: ");

        // Creating StringBuilder and append method
        StringBuilder stringBuilder = new StringBuilder("Happy");
        stringBuilder.append(" Learning");
        System.out.println(stringBuilder);

        // Delete method
        System.out.println(stringBuilder.delete(0, 1));

        // Insert method
        System.out.println(stringBuilder.insert(1, "Welcome"));

        // Reverse method
        System.out.println(stringBuilder.reverse());

        System.out.println("\nConversion of Strings to StringBuffer and StringBuilder: ");

        // String object to StringBuffer
        StringBuffer stringToBuffer = new StringBuffer(inputString);
        stringToBuffer.reverse();
        System.out.println("String to StringBuffer: ");
        System.out.println(stringToBuffer);

        // String object to StringBuilder
        StringBuilder stringToBuilder = new StringBuilder(inputString);
        stringToBuilder.append(" All the Best!");
        System.out.println("String to StringBuilder: ");
        System.out.println(stringToBuilder);
    }
}
