package associativeArraysLambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CompanyUsers {

	public CompanyUsers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, List<String>> map = new LinkedHashMap<>();
		
		String comString = sc.nextLine();
		
		while (!comString.equals("End")) {
			String[] tokens = comString.split(" -> ");
			if(!map.containsKey(tokens[0])) {
				map.put(tokens[0], new ArrayList<>());
				map.get(tokens[0]).add(tokens[1]);
			}
			else {
				map.get(tokens[0]).add(tokens[1]);
			}
			comString = sc.nextLine();
		}
		
		for(Map.Entry<String, List<String>> entry:map.entrySet()) {
			System.out.println(entry.getKey());
			for (String string : entry.getValue()) {
				System.out.println("-- " +string);
			}
		}
		sc.close();
	}

}
