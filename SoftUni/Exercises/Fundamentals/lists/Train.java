package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> train = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		int capacity = Integer.parseInt(sc.nextLine());
		String command = sc.nextLine();
		
		while(!command.equals("end")) {
			String[] tokens = command.split(" ");
			
			if(tokens[0].equals("Add")) {
				int passangers = Integer.parseInt(tokens[1]);
				train.add(passangers);
			}
			else {
				int passangers = Integer.parseInt(tokens[0]);
				for (int i = 0; i < train.size(); i++) {
					if(passangers + train.get(i) <= capacity) {
						train.set(i, passangers + train.get(i));	
						break;
					}
				}
			}			
			command = sc.nextLine();
		}
		for (Integer integer : train) {
			System.out.print(integer+" ");
		}
		sc.close();
	}

}
