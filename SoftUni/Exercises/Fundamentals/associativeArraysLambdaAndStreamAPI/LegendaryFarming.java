package associativeArraysLambdaAndStreamAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {

	public LegendaryFarming() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> materialsMap = new LinkedHashMap<>();
			
		materialsMap.put("shards", 0);
		materialsMap.put("fragments", 0);
		materialsMap.put("motes", 0);
		i:while(true) {
			String[] materials = sc.nextLine().split("\\s+");
			for(int i = 0; i < materials.length; i+=2) {
				String mat = materials[i+1].toLowerCase();
				if(materialsMap.containsKey(mat))materialsMap.put(mat, materialsMap.get(mat)+Integer.parseInt(materials[i]));
				else materialsMap.put(mat, Integer.parseInt(materials[i]));	
				if(materialsMap.get("shards") >= 250) {
					System.out.println("Shadowmourne obtained!");
					materialsMap.put("shards", materialsMap.get("shards")-250);
					break i;
				}
				if(materialsMap.get("fragments") >= 250) {
					System.out.println("Valanyr obtained!");
					materialsMap.put("fragments", materialsMap.get("fragments")-250);
					break i;
				}
				if(materialsMap.get("motes") >= 250) {
					System.out.println("Dragonwrath obtained!");
					materialsMap.put("motes", materialsMap.get("motes")-250);
					break i;
				}
			}
			
		}
		for (Map.Entry<String, Integer> entry: materialsMap.entrySet()) {
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
		}
		sc.close();
	}

}
