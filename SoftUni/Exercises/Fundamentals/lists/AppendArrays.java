package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> arrays = Arrays.stream(sc.nextLine().trim().split("\\|+")).collect(Collectors.toList());
		List<Double> list = new ArrayList<>();
		Collections.reverse(arrays);
		for(int i = 0; i < arrays.size(); i++) {
			List<Double> array = Arrays.stream(arrays.get(i).trim().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
			list.addAll(array);
		}
		for(Double num : list) {
			System.out.printf("%.0f ", num);
		}
		sc.close();
	}

}
