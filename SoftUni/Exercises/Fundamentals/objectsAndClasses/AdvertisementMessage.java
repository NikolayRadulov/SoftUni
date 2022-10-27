package objectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

	private static class Message {
		private final String phrase;
		private final String event;
		private final String author;
		private final String city;
		
		private Message(String phrase, String event, String author, String city) {
			this.phrase = phrase;
			this.event = event;
			this.author = author;
			this.city = city;
		}
		
		@Override
		public String toString() {
			return String.format("%s %s %s – %s", this.phrase, this.event, this.author, this.city);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int n = Integer.parseInt(sc.nextLine());
		String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
		String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
		String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
		String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};	
		
		for(int i = 0; i < n; i++) {
			int randomIndex1 = random.nextInt(phrases.length);
			int randomIndex2 = random.nextInt(events.length);
			int randomIndex3 = random.nextInt(authors.length);
			int randomIndex4 = random.nextInt(cities.length);
			
			System.out.println(new Message(phrases[randomIndex1], events[randomIndex2], authors[randomIndex3], cities[randomIndex4]).toString());
		}
		
		sc.close();

	}

}
