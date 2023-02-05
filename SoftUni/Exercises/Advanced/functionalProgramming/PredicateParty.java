package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BiPredicate<String, String> startsWith = (name, prefix) -> name.startsWith(prefix);
		BiPredicate<String, String> endsWith = (name, suffix) -> name.endsWith(suffix);
		BiPredicate<String, Integer> isLongEnough = (name, length) -> name.length() == length;
		
		List<String> names = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
		
		String input = sc.nextLine();
		while (!input.equals("Party!")) {
			String[] tokens = input.split("\\s+");
			switch (tokens[0]) {
			case "Remove": {
				switch (tokens[1]) {
					case "StartsWith": {
						for (int i = 0; i < names.size(); i++) {
							if(startsWith.test(names.get(i), tokens[2])) names.set(i, "");
						}
					}				
					break;		
					case "EndsWith": {
						for (int i = 0; i < names.size(); i++) {
							if(endsWith.test(names.get(i), tokens[2])) names.set(i, "");
						}
					}
					break;
					case "Length": {
						for (int i = 0; i < names.size(); i++) {
							if(isLongEnough.test(names.get(i), Integer.parseInt(tokens[2]))) names.set(i, "");;
						}
					}
					break;
				}
			}
		break;
			case "Double":  {
				switch(tokens[1]) {
					case "StartsWith": {
						for (int i = 0; i < names.size(); i++) {
							if(startsWith.test(names.get(i), tokens[2])) {
								names.add(i, names.get(i));
								i++;
							}
						}
					}				
					break;		
					case "EndsWith": {
						for (int i = 0; i < names.size(); i++) {
							if(endsWith.test(names.get(i), tokens[2])) {
								names.add(i, names.get(i));
								i++;
							}
						}
					}
					break;
					case "Length": {
						for (int i = 0; i < names.size(); i++) {
							if(isLongEnough.test(names.get(i), Integer.parseInt(tokens[2]))) {
								names.add(i, names.get(i));
								i++;
							}
						}
					}
					break;
					}
				}
				
			}
	
			input = sc.nextLine();
		} 
		for (int i = 0; i < names.size(); i++) {
			if(i < names.size() && names.get(i).equals("")) {
				names.remove(i);
				i--;
			}
		}
		if(names.isEmpty()) {
			System.out.println("Nobody is going to the party!");
			sc.close();
			return;
		} 
		Collections.sort(names);
		
		System.out.println(String.join(", ", names) + " are going to the party!");
		sc.close();
	}
} 
