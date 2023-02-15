package setsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		Map<String, String> map = new HashMap<>();
		
		while (!input.equals("search")) {
			String[] tokens = input.split("-");
			map.put(tokens[0], tokens[1]);		
			input = sc.nextLine();
		}
		input = sc.nextLine();
		while (!input.equals("stop")) {
			if(!map.containsKey(input)) System.out.printf("Contact %s does not exist.%n", input);
			else System.out.printf("%s -> %s%n", input, map.get(input));
			
			input = sc.nextLine();
		}
		sc.close();
	}

}
