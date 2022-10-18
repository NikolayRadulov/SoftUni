package dataTypesAndVariables;

import java.util.Scanner;

public class Elevator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = Integer.parseInt(sc.nextLine());
		int capacity = Integer.parseInt(sc.nextLine());
		if(people == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		int lifts;
		if(people % capacity == 0) lifts = (int) ((double)people/(double)capacity);
		else lifts = (int) ((double)people/(double)capacity+1);
		System.out.printf("%d", lifts);
		sc.close();
	}

}
