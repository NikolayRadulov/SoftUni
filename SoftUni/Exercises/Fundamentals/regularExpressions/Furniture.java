package regularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		Pattern pattern = Pattern.compile("(>>[A-z]+<<)([0-9]+\\.?[0-9]*)!([0-9]+)");
		List<String> furniture = new ArrayList<>();
		double money = 0;
		String command = sc.nextLine();
		
		while(!command.equals("Purchase")) {
			Matcher matcher = pattern.matcher(command.trim());
			if(matcher.find()) {
				furniture.add(matcher.group(1));
				money += Double.parseDouble(matcher.group(2))*Double.parseDouble(matcher.group(3));
			}
			command = sc.nextLine();
		}
		System.out.println("Bought furniture:");
		for (String string : furniture) {
			System.out.println(string.substring(2, string.length()-2));
		}
		System.out.printf("Total money spend: %.2f", money);
		sc.close();
	}

}
