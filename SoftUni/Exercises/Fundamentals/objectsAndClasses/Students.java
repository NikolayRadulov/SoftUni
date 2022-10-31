package objectsAndClasses;

import java.util.Scanner;

public class Students {

	private static class Student {
		
		private String firstName;
		private String lastName;
		private double grade;
		
		private Student(String firstName, String lastName, double grade) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.grade = grade;
		}

		public double getGrade() {
			return grade;
		}
		
		@Override
		public String toString() {
			return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			String[] studentStats = sc.nextLine().split("\\s+");
			students[i] = new Student(studentStats[0], studentStats[1], Double.parseDouble(studentStats[2]));
		}
		sc.close();
		sortStudents(students);

		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	
	private static void sortStudents(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getGrade() > students[j].getGrade()) {
					Student buff = students[i];
					students[i] = students[j];
					students[j] = buff;
				}
			}
		}
	}
}
