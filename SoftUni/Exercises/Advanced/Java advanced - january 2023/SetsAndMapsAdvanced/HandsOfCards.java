package setsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class HandsOfCards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		Map<String, Set<String>> map = new LinkedHashMap<>();
		while (!input.equals("JOKER")) {
			String[] tokens = input.split(": ");
			List<String> cards = Arrays.stream(tokens[1].split(", ")).collect(Collectors.toList());
			Set<String> deck = new LinkedHashSet<>();
			deck.addAll(cards);
			if(map.containsKey(tokens[0])) map.get(tokens[0]).addAll(cards);	
			else map.put(tokens[0], deck);
			input = sc.nextLine();
		}
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			String name = entry.getKey();
			Set<String> deck = entry.getValue();		
			int sum = 0;
			for (String card : deck) {
				int power = 0, multiplier = 0;
				switch (card.charAt(0)) {
					case 'A':
						power = 14;
					break;
					case 'K':
						power = 13;
					break;
					case 'Q':
						power = 12;
					break;
					case 'J':
						power = 11;
					break;
					default:
						power = Integer.parseInt(card.substring(0,card.length()-1));
					break;
				}
				switch (card.charAt(card.length()-1)) {
					case 'S':
						multiplier = 4;
					break;
					case 'H':
						multiplier = 3;
					break;
					case 'D':
						multiplier = 2;
					break;
					case 'C':
						multiplier = 1;
					break;
				}			
				sum += (power*multiplier);
			}
			System.out.printf("%s: %d%n", name, sum);
		}
		sc.close();
	}

}
