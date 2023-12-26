package Conversions;

public class typecastings{
	public static void main(String[] args) {
		
		//Implicit type casting
		int a = 101;
		double b = a;
		System.out.println("After Implicit casting from 'int a' to 'double b' the values will be: ");
		System.out.println("int a = " + a);
		System.out.println("double b = " + b);
		
		// Explicit type casting
		long c = 10787900090L;
		int d = (int) c;
		System.out.println("\nAfter Explicit casting from 'long c' to 'int d' the values will be:");
		System.out.println("long c = " + c);
		System.out.println("int d = " + d);
		
	}
}