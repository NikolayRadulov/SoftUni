package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.stream(sc.nextLine().trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		int bomb = Integer.parseInt(sc.next());
		int power = Integer.parseInt(sc.next());
		
		for(int i = 0; i < list.size(); i++) {	
			if(list.get(i) == bomb) {
				int start = i-power;
				int end = i+power;
				if(start < 0) start = 0;
				if(end >= list.size()) end = list.size()-1;
				for(int j = start; j <= end; j++) {
					list.remove(start);
				}
				i = -1;
			}
		}
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		System.out.println(sum);
		sc.close();
	}

}
