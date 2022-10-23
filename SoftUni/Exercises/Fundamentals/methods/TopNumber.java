package methods;

import java.util.Scanner;

public class TopNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			if(isTopNumber(i)) System.out.println(i);
		}
		
		sc.close();
	}
	
	private static boolean isTopNumber(int num) {	
		return findDigitSum(num)%8 == 0 && hasOdd(num);
	}
	
	private static int findDigitSum(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num%10;
			num /= 10;
		} 
		return sum;
	}
	private static boolean hasOdd(int num) {
		while(num > 0) {
			if((num%10)%2 != 0) return true;
			num /= 10;
		} 
		return false;
	}

}
