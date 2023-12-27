package calci;
import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Arithmetic Calculator!");

        System.out.print("Enter the total number of values you want to calculate: ");
        int totalValues = scanner.nextInt();
        
        double[] numbers = new double[totalValues];
        
        for (int i = 0; i < totalValues; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            double result = 0;

            switch (choice) {
                case 1:
                    for (double num : numbers) {
                        result += num;
                    }
                    break;
                case 2:
                    result = numbers[0]; // Initialize result with the first number
                    for (int i = 1; i < totalValues; i++) {
                        result -= numbers[i];
                    }
                    break;
                case 3:
                    result = 1; // Initialize result with 1 for multiplication
                    for (double num : numbers) {
                        result *= num;
                    }
                    break;
                case 4:
                    result = numbers[0]; // Initialize result with the first number
                    for (int i = 1; i < totalValues; i++) {
                        if (numbers[i] != 0) {
                            result /= numbers[i];
                        } else {
                            System.out.println("Error! Division by zero is not allowed.");
                            result = 0;
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Arithmetic Calculator. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                    continue;
            }

            System.out.println("Result: " + result);
        }
    }
}
