package dataTypesAndVariables;

import java.util.Scanner;

public class TripleLatinLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 'a'; i < n+'a'; i++) {
			for (int j = 'a'; j < n+'a'; j++) {
				for (int j2 = 'a'; j2 < n+'a'; j2++) {
					System.out.println((char)i + "" + (char)j + "" + (char)j2);
				}
			}
		}
		sc.close();
	}

}
