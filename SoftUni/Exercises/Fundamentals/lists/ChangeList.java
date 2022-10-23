package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		
		String command = sc.nextLine();
		
		while(!command.equals("end")) {
			String[] tokens = command.split(" ");
			switch(tokens[0]) {
				case "Delete": {
					int num = Integer.parseInt(tokens[1]);
					list.removeAll(Arrays.asList(num));
				}
				break;
				case "Insert": {
					int num = Integer.parseInt(tokens[1]);
					int index = Integer.parseInt(tokens[2]);
					list.add(index, num);
				}
				break;
			}
			command = sc.nextLine();
		}
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		sc.close();
	}

}
