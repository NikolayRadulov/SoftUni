package setsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String text = sc.nextLine();
		
		Map<Character, Integer> map = new TreeMap<>();
		for(char ch : text.toCharArray()) {
			if(map.containsKey(ch))map.put(ch, map.get(ch)+1);
			else map.put(ch, 1);
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
		}
		sc.close();
	}

}
