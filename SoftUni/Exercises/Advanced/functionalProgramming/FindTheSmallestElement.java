package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		System.out.println(isMin.apply(arr));
		sc.close();
	}
	
	private static Function<int[], Integer> isMin = new Function<int[], Integer>() {
		@Override
		public Integer apply(int[] nums) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 0; i < nums.length; i++) {
				if(nums[i] <= min) {
					min = nums[i];
					minIndex = i;
				}
			}
			return minIndex;
		}
	};
}
