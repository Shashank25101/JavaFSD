package emails;
import java.util.Scanner;

public class Email {

    public static int findEmailIndex(String[] emails, String searchEmail) {
        for (int i = 0; i < emails.length; i++) {
            if (emails[i].equals(searchEmail)) {
                return i; // Return the index where the email is found
            }
        }
        return -1; // Return -1 if the email is not found
    }

    public static void main(String[] args) {
        String[] emailArray = {
            "ram@gmail.com",
            "shruthi24@yahoo.com",
            "arunyadav@gmail.com",
            "varun@gmail.com",
            "maurya@gmail.com"
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the email ID to search: ");
        String searchEmail = scanner.nextLine();

        int foundIndex = findEmailIndex(emailArray, searchEmail);

        if (foundIndex != -1) {
            System.out.println("Email ID found at index: " + foundIndex);
        } else {
            System.out.println("Email ID not found in the list.");
        }

        scanner.close();
    }
}


    