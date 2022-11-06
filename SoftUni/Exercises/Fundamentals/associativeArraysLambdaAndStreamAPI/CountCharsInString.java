package associativeArraysLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(char ch:str.toCharArray()) {
			if(ch == ' ') continue;
			
			if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
			else map.put(ch, 1);
		}
		
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
		}
		
		sc.close();
	}

}
