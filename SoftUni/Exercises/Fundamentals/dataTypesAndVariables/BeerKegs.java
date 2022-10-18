package dataTypesAndVariables;

import java.util.Scanner;

public class BeerKegs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		double maxVolume = -1;
		String biggestModel = "";
		for (int i = 0; i < n; i++) {
			String model = sc.nextLine();
			double radius = Double.parseDouble(sc.nextLine());
			int height = Integer.parseInt(sc.nextLine());
			double volume = Math.PI * Math.pow(radius, 2) * height;
			if(volume > maxVolume) {
				biggestModel = model;
				maxVolume = volume;
			}
		}
		System.out.println(biggestModel);
		sc.close();
	}

}
