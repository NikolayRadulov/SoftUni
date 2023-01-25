package setsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		Set<String> chemicalSet = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			String[] chemicals = sc.nextLine().split("\\s+");
			for (String string : chemicals) {
				if(!chemicalSet.contains(string)) chemicalSet.add(string);
			}
		}
		for (String string : chemicalSet) {
			System.out.print(string+" ");
		}
		
		sc.close();
	}

}
