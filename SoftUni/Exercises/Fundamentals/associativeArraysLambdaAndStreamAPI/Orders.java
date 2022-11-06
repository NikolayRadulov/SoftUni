package associativeArraysLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

	private static class Pair {
		int quantity;
		double price;
		private Pair(int quantity, double price) {
			this.quantity = quantity;
			this.price = price;
		}	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		Map<String, Pair> map = new LinkedHashMap<>();
		
		while(!command.equals("buy")) {
			String[] tokens = command.split("\\s+");
			
			if(map.containsKey(tokens[0])) map.put(tokens[0], new Pair(map.get(tokens[0]).quantity+Integer.parseInt(tokens[2]), Double.parseDouble(tokens[1])));
			else map.put(tokens[0], new Pair(Integer.parseInt(tokens[2]), Double.parseDouble(tokens[1])));
			command = sc.nextLine();
		}
		for (Map.Entry<String, Pair> entry: map.entrySet()) {
			Pair pair = entry.getValue();
			System.out.printf("%s -> %.2f%n", entry.getKey(), pair.price*pair.quantity);
		}
		sc.close();

	}

}
