package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class Vacation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		String tripType = sc.nextLine();
		String day = sc.nextLine();
		double price = 0;
		double discount = 0;
		switch(tripType) {
			case "Students": {
				switch(day) {
					case "Friday": price = 8.45;
					break;
					case "Saturday": price = 9.80;
					break;
					case "Sunday": price = 10.46;
					break;
				}
				if(count >= 30) discount = 0.15;
			}
			break;
			case "Business": {
				switch(day) {
					case "Friday": price = 10.90;
					break;
					case "Saturday": price = 15.60;
					break;
					case "Sunday": price = 16;
					break;
				}
				if(count >= 100) count -= 10;
			}
			break;
			case "Regular": {
				switch(day) {
					case "Friday": price = 15;
					break;
					case "Saturday": price = 20;
					break;
					case "Sunday": price = 22.50;
					break;
				}
				if(count >= 10 && count <= 20) discount = 0.05;
			}
			break;
		}
		double totalPrice = (count*price);
		System.out.printf("Total price: %.2f", (totalPrice - totalPrice*discount));
		sc.close();
	}

}
