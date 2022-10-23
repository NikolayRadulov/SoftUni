package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<String> list = new ArrayList<>();
		
		
		i:for(int i = 0; i < n; i++) {
			String[] command = sc.nextLine().split(" ");
			if(command.length == 3) {
				if(list.contains(command[0])) {
					System.out.println(command[0] + " is already in the list!");
					continue i;
				} 
				else list.add(command[0]);
			}
			else {
				if(!list.contains(command[0])) {
					System.out.println(command[0] + " is not in the list!");
					continue i;
				} 
				else list.remove(command[0]);
			}		
		}
		for (String name : list) {
			System.out.println(name);
		}
		sc.close();
	}

}
