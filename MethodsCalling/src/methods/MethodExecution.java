//normal method execution
package methods;
import java.util.Scanner;
public class MethodExecution {
	public int multipy(int a,int b) {
		int product = a*b;
		return product;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MethodExecution obj = new MethodExecution();
		System.out.println("Enter the two numbers to be multiplied:  ");
		System.out.printf("num1= ");
		int num1 = scan.nextInt();
		System.out.printf("num2= ");
		int num2 = scan.nextInt();
		int answer = obj.multipy(num1,num2);
		System.out.println("Multipilcation is : "+answer);
		scan.close();
		}

}
