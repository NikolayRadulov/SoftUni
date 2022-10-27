package objectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

	private static class Person {
		private final String name;
		private final int age;
		private Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public int getAge() {
			return age;
		}
		
		@Override
		public String toString() {
			return name + " - " + age;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			String[] personStats = sc.nextLine().split("\\s+");
			Person person = new Person(personStats[0], Integer.valueOf(personStats[1]));
			if(person.getAge() > 30) {
				System.out.println(person.toString());
			}
		}

		sc.close();
	}

}
