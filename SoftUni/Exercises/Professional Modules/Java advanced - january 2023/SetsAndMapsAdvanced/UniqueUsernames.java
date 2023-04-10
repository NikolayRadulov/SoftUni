package setsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Set<String> set = new LinkedHashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(sc.nextLine());
		}
		
		for (String string : set) {
			System.out.println(string);
		}
		
		
		sc.close();
	}

}
