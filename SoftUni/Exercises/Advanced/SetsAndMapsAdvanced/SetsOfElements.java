package setsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		sc.nextLine();
		
		Set<Integer> first = new LinkedHashSet<>();
		Set<Integer> second = new LinkedHashSet<>();
		
		for (int i = 0; i < n; i++) {
			first.add(sc.nextInt());
		}
		for (int i = 0; i < m; i++) {
			second.add(sc.nextInt());
		}
		
		for(Integer num : first) {
			if(second.contains(num)) System.out.print(num + " ");
		}
		sc.close();
	}

}
