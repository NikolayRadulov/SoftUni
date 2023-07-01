package fundamentals.exam_prep1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trains {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String[]> slots = new ArrayList<>();
		
		String[] arriving = sc.nextLine().split("\\s+");
		String[] departing = sc.nextLine().split("\\s+");
		
		
		if(arriving.length == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		slots.add(new String[]{arriving[0], departing[0]});
		
		for(int i = 1; i < arriving.length; i++) {
			int size = slots.size();
			boolean toAdd = true;		
			for(int j = 0; j < size; j++) {
				if(isLater(arriving[i], slots.get(j)[1]) || isLater(slots.get(j)[0], departing[i])) {
					slots.set(j, new String[]{arriving[i], departing[i]});
					toAdd = false;
					break;
				}	
			}
			if(toAdd) slots.add(new String[]{arriving[i], departing[i]});
		}
		
		System.out.println(slots.size());
		sc.close();

	}
	
	private static boolean isLater(String orgTime1, String orgTime2) {
		
		String[] time1 = orgTime1.split("\\.");
		String[] time2 = orgTime2.split("\\.");	
		
		int h1 = Integer.parseInt(time1[0]);
		int m1 = Integer.parseInt(time1[1]);
		int h2 = Integer.parseInt(time2[0]);
		int m2 = Integer.parseInt(time2[1]);
		
		if(h1 > h2 || (h1 == h2 && m1 >= m2)) return true; 
		
		return false;
	}

}
