package objectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorielOfN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(getFactoriel(new BigInteger(sc.nextLine())));
		sc.close();
	}
	
	private static BigInteger getFactoriel(BigInteger n) {
		if(n.equals(new BigInteger("1"))) return new BigInteger("1");
		
		return n.multiply(getFactoriel(n.subtract(new BigInteger("1"))));
	}

}
