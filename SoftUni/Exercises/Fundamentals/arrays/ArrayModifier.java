package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		String command = sc.nextLine();
		while(!command.equals("end")) {
			String[] tokens = command.split("\\s+");
			switch(tokens[0]) {
				case "swap": {
					int index1 = Integer.parseInt(tokens[1]);
					int index2 = Integer.parseInt(tokens[2]);
					int buff = arr[index1];
					arr[index1] = arr[index2];
					arr[index2] = buff;
				}
				break;
				case "multiply": {
					int index1 = Integer.parseInt(tokens[1]);
					int index2 = Integer.parseInt(tokens[2]);
					arr[index1] = arr[index1]*arr[index2];
				}
				break;
				case "decrease": {
					for(int i = 0; i < arr.length; i++) arr[i]--;
				}
				break;
			}
			command = sc.nextLine();
		}
		String ans = "";
		for(int i = 0; i < arr.length; i++) {
			ans += arr[i] + ", ";
		}
		System.out.println(ans.substring(0, ans.length()-2));
		sc.close();
	}

}
