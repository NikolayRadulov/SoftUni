package associativeArraysLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		Map<String, Integer> map = new LinkedHashMap<>();
		
		while(!command.equals("stop")) {
			int quantity = Integer.parseInt(sc.nextLine());
			
			if(map.containsKey(command)) map.put(command, map.get(command)+quantity);
			else map.put(command, quantity);
			command = sc.nextLine();
		}
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
		}
		sc.close();
	}

}
