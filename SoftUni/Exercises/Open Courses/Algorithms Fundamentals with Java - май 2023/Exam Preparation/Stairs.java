package fundamentals.exam_prep1;
import java.util.HashMap;
import java.util.Scanner;

public class Stairs {

	private static HashMap<Long, Long> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stairs = Integer.parseInt(sc.nextLine());

		map = new HashMap<>();
		
		System.out.println(climb(0, stairs));
		
		sc.close();
	}
	
	private static long climb(long step, int stairs) {
		if(step > stairs) return 0;
		
		if(map.containsKey(step)) return map.get(step);
		
		if(step == stairs) {
			return 1;
		}
		
		
		long a = climb(step+1, stairs);
		long b = climb(step+2, stairs);
		
		map.put(step, a+b);
		return a + b;
	}

}
