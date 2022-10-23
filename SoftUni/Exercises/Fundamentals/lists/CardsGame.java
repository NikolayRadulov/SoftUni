package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> deck1 = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> deck2 = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		
		while(!deck1.isEmpty() && !deck2.isEmpty()) {
			int firstCard = deck1.get(0);
			int secondCard = deck2.get(0);
			
			if(firstCard > secondCard) {
				deck1.add(firstCard);
				deck1.add(secondCard);
				deck1.remove(0);
				deck2.remove(0);
			}
			else if(firstCard < secondCard) {
				deck2.add(secondCard);
				deck2.add(firstCard);
				deck1.remove(0);
				deck2.remove(0);
			}
			else {
				deck1.remove(0);
				deck2.remove(0);
			}
		}
		
		if(deck1.isEmpty()) {
			int sum = 0;
			for (int i = 0; i < deck2.size(); i++) {
				sum += deck2.get(i);
			}
			System.out.printf("Second player wins! Sum: %d", sum);
		}
		if(deck2.isEmpty()) {
			int sum = 0;
			for (int i = 0; i < deck1.size(); i++) {
				sum += deck1.get(i);
			}
			System.out.printf("First player wins! Sum: %d", sum);
		}
		
		sc.close();
	}

}
