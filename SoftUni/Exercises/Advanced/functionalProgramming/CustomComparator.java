package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {

	private static class CusComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 % 2 == 0 && o2 % 2 != 0) return -1;
			else if(o1 % 2 != 0 && o2 % 2 == 0) return 1;
			return o1.compareTo(o2);
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

		Collections.sort(list, new CusComparator());
		sc.close();
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}

}
