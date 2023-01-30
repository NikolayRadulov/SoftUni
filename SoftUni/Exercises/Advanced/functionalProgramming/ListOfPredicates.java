package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		Predicate<Integer> isDivisable = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				for (int num:arr) {
					if(t % num != 0) return false;
				}
				
				return true;
			}
		};
		for (int i = 1; i <=n ; i++) {
			if(isDivisable.test(i)) System.out.print(i+" ");
		}
		sc.close();
	}

}
