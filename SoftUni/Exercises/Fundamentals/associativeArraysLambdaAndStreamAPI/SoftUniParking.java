package associativeArraysLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new LinkedHashMap<>();

		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			String[] command = sc.nextLine().split("\\s+");
			
			if(command[0].equals("register")) {
				if(isPresent(map, command[1])) System.out.println("ERROR: already registered with plate number " + command[2]);
				else {
					map.put(command[1], command[2]);
					System.out.printf("%s registered %s successfully%n", command[1], command[2]);
				}
			}
			else {
				if(!isPresent(map, command[1])) System.out.printf("ERROR: user %s not found%n", command[1]);
				else {
					map.remove(command[1]);
					System.out.println(command[1] + " unregistered successfully");
				}
			}
		}
		sc.close();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s => %s", entry.getKey(), entry.getValue());
		}
	}
	
	private static boolean isPresent(Map<String, String> map, String username) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey().equals(username)) return true;
		}
		return false;
	}

}
