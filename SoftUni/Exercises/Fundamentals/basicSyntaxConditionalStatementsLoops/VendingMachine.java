package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		double totalMoney = 0;
		while(!command.equals("Start")) {
			double coin = Double.parseDouble(command);
			if(coin != 0.10 && coin != 0.20 && coin != 0.50 && coin != 1 && coin != 2) System.out.printf("Cannot accept %.2f%n", coin);
			else totalMoney += coin;
			command = sc.nextLine();
		}
		command = sc.nextLine();
		while(!command.equals("End")) {
			double price = 0;
			switch(command) {
				case "Nuts": price = 2.0;
				break;
				case "Water": price = 0.7;
				break;
				case "Crisps": price = 1.5;
				break;
				case "Soda": price = 0.8;
				break;
				case "Coke": price = 1.0;
				break;
				default: {
					System.out.println("Invalid product");
					command = sc.nextLine();
					continue;
				}
			}
			if(price <= totalMoney) {
				System.out.println("Purchased " + command);
				totalMoney -= price;
			}
			else System.out.println("Sorry, not enough money");
			command = sc.nextLine();
		}
		System.out.printf("Change: %.2f", totalMoney);
		
		
		sc.close();
	}

}
