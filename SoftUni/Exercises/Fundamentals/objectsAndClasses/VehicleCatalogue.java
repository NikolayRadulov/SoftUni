package objectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

	private static class Vehicle {
		
		private String type;
		private String model;
		private String color;
		private int horsePower;
		
		private Vehicle(String type, String model, String color, int horsePower) {
			this.type = type;
			this.model = model;
			this.color = color;
			this.horsePower = horsePower;
		}
		
		public String getModel() {
			return this.model;
		}
		public String getType() {
			return this.type;
		}
		public int getHorsePower() {
			return this.horsePower;
		}
		
		@Override
		public String toString() {
			String type = "";
			if(this.type.equals("car"))type = "Car";
			else type = "Truck";
			return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", type, this.model, this.color, this.horsePower);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		List<Vehicle> vehicles = new ArrayList<>();
		List<Vehicle> listedVehicles = new ArrayList<>();
		while(!command.equals("End")) {
			String[] vehicle = command.split("\\s+");
			vehicles.add(new Vehicle(vehicle[0], vehicle[1], vehicle[2], Integer.parseInt(vehicle[3])));		
			command = sc.nextLine();
		}
		command = sc.nextLine();
		while(!command.equals("Close the Catalogue")) {
			Vehicle vehicle = findVehicle(vehicles, command);
			System.out.println(vehicle.toString());		
			listedVehicles.add(vehicle);
			command = sc.nextLine();
		}
		printAvarageHorsePower(vehicles);
		sc.close();
	}

	private static Vehicle findVehicle(List<Vehicle> vehicles, String model) {
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getModel().equals(model)) return vehicle;
		}
		return null;
	}
	
	private static void printAvarageHorsePower(List<Vehicle> vehicles) {
		int carsHorsePowers = 0, carsCount = 0;
		int trucksHorsePowers = 0, trucksCount = 0;;
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getType().equals("car")) {
				carsCount++;
				carsHorsePowers+=vehicle.getHorsePower();
			}
			else {
				trucksCount++;
				trucksHorsePowers+=vehicle.getHorsePower();
			}
		}
		double horsePowerCars;
		if(carsCount == 0) horsePowerCars = 0.00;
		else horsePowerCars = (carsHorsePowers/(double)carsCount);
		double horsePowerTrucks;
		if(trucksCount == 0) horsePowerTrucks = 0.00;
		else horsePowerTrucks = (trucksHorsePowers/(double)trucksCount);
		System.out.printf("Cars have average horsepower of: %.2f.%n", horsePowerCars);
		System.out.printf("Trucks have average horsepower of: %.2f.", horsePowerTrucks);
	}
}
