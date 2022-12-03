package regularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {

	public BarIncome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		Pattern pattern = Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$");
		
		double total = 0;
		while (!command.equals("end of shift")) {
			Matcher matcher = pattern.matcher(command);
			if(!matcher.find()) {
				command = sc.nextLine();
				continue;
			}
			double price = Double.parseDouble(matcher.group("price"));
			int count = Integer.parseInt(matcher.group("count"));
			System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), count*price);

			total+=count*price;
			command = sc.nextLine();
		}
		System.out.printf("Total income: %.2f", total);
		sc.close();
	}

}
