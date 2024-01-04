package fixbugs;

import java.util.ArrayList;
import java.util.*;

public class Main {
    // Original expenses
    private static ArrayList<Integer> expenses = new ArrayList<>();
    static {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
    }

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }

    private static void optionsSelection() {
        String[] arr = {
            "1. I wish to review my expenditure",
            "2. I wish to add my expenditure",
            "3. I wish to delete all my expenditure",
            "4. I wish to sort the expenditures",
            "5. I wish to search for a particular expenditure",
            "6. Close the application"
        };
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int slen = arr1.length;
        for (int i = 0; i < slen; i++) {
            System.out.println(arr[i]);
        }
        
        int options;
        System.out.println("Enter your choice: \n");
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        options = scan.nextInt();

        switch (options) {
            case 1:
                System.out.println("Your saved expenses are listed below: \n" + expenses + "\n");
                optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: \n");
                int value = scan.nextInt();
                expenses.add(value);
                System.out.println("Your value is updated\n");
                System.out.println(expenses + "\n");
                optionsSelection();
                break;
            case 3:
                System.out.println("You are about to delete all your expenses! \nConfirm again by selecting the same option...\n");
                int con_choice = scan.nextInt();
                if (con_choice == options) {
                    expenses.clear();
                    System.out.println("All your expenses are erased!\n");
                } else {
                    System.out.println("Oops... try again!");
                }
                optionsSelection();
                break;
            case 4:
                sortExpenses(expenses);
                optionsSelection();
                break;
            case 5:
                searchExpenses(expenses);
                optionsSelection();
                break;
            case 6:
                closeApp();
                break;
            default:
                System.out.println("You have made an invalid choice!");
                break;
        }
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        @SuppressWarnings("unused")
		int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        int expenseToSearch = scan.nextInt();

        if (arrayList.contains(expenseToSearch)) {
            int index = arrayList.indexOf(expenseToSearch);
            System.out.println("Expense found at index " + index + ": " + expenseToSearch);
        } else {
            System.out.println("Expense not found.");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength = arrayList.size();
        // Complete the method. The expenses should be sorted in ascending order.
        for (int i = 0; i < arrlength - 1; i++) {
            for (int j = 0; j < arrlength - i - 1; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    // Swap elements if they are in the wrong order
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Expenses sorted in ascending order: " + arrayList);
    }
}

