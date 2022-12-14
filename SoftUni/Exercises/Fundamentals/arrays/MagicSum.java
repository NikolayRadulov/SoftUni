package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int targetNum = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
			    if(arr[i]+arr[j] == targetNum) {
			    	System.out.println(arr[i] + " " + arr[j]);
			    }
			}
		}
		sc.close();
	}

}
