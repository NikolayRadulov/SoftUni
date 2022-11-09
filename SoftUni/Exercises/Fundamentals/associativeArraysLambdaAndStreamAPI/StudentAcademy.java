package associativeArraysLambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, List<Double>> map = new LinkedHashMap<>();
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String name = sc.nextLine();
			double grade = Double.parseDouble(sc.nextLine());
			if(map.containsKey(name)) map.get(name).add(grade);
			else {
				map.put(name, new ArrayList<>());
				map.get(name).add(grade);
			}
		}
		for (Map.Entry<String, List<Double>> entry: map.entrySet()) {
			double sum = 0;
			for (Double doub: entry.getValue()) {
				sum += doub;
			}
			double avg = (sum/entry.getValue().size());
			if(avg < 4.50) continue;
			System.out.printf("%s -> %.2f%n", entry.getKey(), avg);
		}
		sc.close();
	}

}
