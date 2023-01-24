package setsAndMapsAdvanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new LinkedHashMap<>();
		
		String input = sc.nextLine();
		
		while (!input.equals("stop")) {
			
			String address = sc.nextLine();
			
			String domain = address.split("\\.")[1];
			
			if(domain.equalsIgnoreCase("com") || domain.equalsIgnoreCase("us") || domain.equalsIgnoreCase("uk")) {
				input = sc.nextLine();
				continue;
			}
			map.put(input, address);
			
			input = sc.nextLine();
		}
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
		}
		
		
		sc.close();

	}

}
