package stacksAndQueus;

import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonaci {

	public RecursiveFibonaci() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(findFibonacci(Integer.parseInt(sc.nextLine())+1, new HashMap<>()));
		sc.close();
	}
	
	private static long findFibonacci(long n, HashMap<Long, Long> map) {
		if(n <= 1) {
			map.put(n, n);
			return n;
		}
		
		if(map.containsKey(n)) return map.get(n);
		
		long a = findFibonacci(n-1, map);
		long b = findFibonacci(n-2, map);	
		long result = a+b;
		
		map.put(n, result);
		return result;
	}

}
