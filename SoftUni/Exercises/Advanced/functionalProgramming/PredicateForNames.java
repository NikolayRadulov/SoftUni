package functionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Predicate<String> isLong = name -> name.length() <= n;
		String[] names = sc.nextLine().split("\\s+");
		for (String name:names) {
			if(isLong.test(name)) System.out.println(name);
		}
		sc.close();

	}

}
