package functionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = sc.nextLine().split("\\s+");

		Consumer<String> print = s -> System.out.println(s);
		
		for (String string : names) {
			print.accept(string);
		}
		sc.close();
	}

}
