package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());		
		int n = Integer.parseInt(sc.nextLine());	
		Consumer<List<Integer>> reverse = (nums)-> Collections.reverse(list);
		Consumer<List<Integer>> strip = new Consumer<List<Integer>>() {
			@Override
			public void accept(List<Integer> t) {
				int size = t.size();
				for (int i = 0; i < size; i++) {
					if (i < t.size() && t.get(i)%n == 0) {
						t.remove(t.get(i));
						i--;
					}
				}
				
			}

			
		};
		
		reverse.accept(list);
		strip.accept(list);
		
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		sc.close();

	}

}
