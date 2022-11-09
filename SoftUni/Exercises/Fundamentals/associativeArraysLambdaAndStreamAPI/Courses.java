package associativeArraysLambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Courses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, List<String>> map = new LinkedHashMap<>();
		String command = sc.nextLine();
		while(!command.equals("end")) {
			String[] tokens = command.split(" : ");
			if(map.containsKey(tokens[0])) map.get(tokens[0]).add(tokens[1]);
			else {
				map.put(tokens[0], new ArrayList<>());
				map.get(tokens[0]).add(tokens[1]);
			}
			command = sc.nextLine();
		}
		for (Map.Entry<String, List<String>> entry: map.entrySet()) {
			System.out.println(entry.getKey()+": " + entry.getValue().size());
			for (String string : entry.getValue()) {
				System.out.println("-- " + string);
			}
		}
		sc.close();
	}

}
