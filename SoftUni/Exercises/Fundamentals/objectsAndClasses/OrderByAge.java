package objectsAndClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

	private static class Person {
		private String name;	
		private String id;		
		private int age;
		
		private Person(String name, String id, int age) {
			super();
			this.name = name;
			this.id = id;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		
		String name = sc.nextLine();
		while(!name.equals("End")) {
			String[] person = name.split("\\s+");
			people.add(new Person(person[0], person[1], Integer.parseInt(person[2])));
			name = sc.nextLine();
		}
		sc.close();
		sortAges(people);
		for (Person person : people) {
			System.out.println(person.toString());
		}
	}

	
	private static void sortAges(List<Person> people) {	
		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < people.size(); j++) {
				if(people.get(j).age > people.get(i).age) {				
					Person buff = people.get(i);
					people.set(i, people.get(j));
					people.set(j, buff);
				}
			}
		}
	}
}
