package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class Orders {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		double totalPrice = 0;
		
		for(int i = 0; i < n; i++) {
			double pricePerCapsule = Double.parseDouble(sc.nextLine());
			int days = Integer.parseInt(sc.nextLine());
			int count = Integer.parseInt(sc.nextLine());
			double price = ((days*count)*pricePerCapsule);
			totalPrice += price;
			System.out.printf("The price for the coffee is: $%.2f%n", price);
		}
		System.out.printf("Total: $%.2f", totalPrice);
		sc.close();
	}

}
