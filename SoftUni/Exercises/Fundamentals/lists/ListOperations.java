package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		String command = sc.nextLine();
		
		while(!command.equals("End")) {
			String[] tokens = command.split(" ");	
			switch(tokens[0]) {
				case "Add": list.add(Integer.parseInt(tokens[1]));
				break;
				case "Insert": {
					int index = Integer.parseInt(tokens[2]);
					if(index < 0 || index > list.size()) {
						System.out.println("Invalid index");
						break;
					}
					list.add(index, Integer.parseInt(tokens[1]));
				}
				break;
				case "Remove": {
					int index = Integer.parseInt(tokens[1]);
					if(index < 0 || index > list.size()) {
						System.out.println("Invalid index");
						break;
					}
					list.remove(index);
				}
				break;
				case "Shift": {
					int count = Integer.parseInt(tokens[2]);
					if(tokens[1].equals("left")) {
						for(int i = 0; i < count; i++) {
							int num = list.remove(0);
							list.add(num); 
						}
					}
					else {
						for(int i = 0; i < count; i++) {
							int num = list.remove(list.size()-1);
							list.add(0, num); 	
						}
					}
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
