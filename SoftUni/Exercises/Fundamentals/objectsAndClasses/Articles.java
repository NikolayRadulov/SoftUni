package objectsAndClasses;

import java.util.Scanner;

public class Articles {

	private static class Article {
		
		private String title;
		private String content;
		private String author;
		
		private Article(String title,String content, String author) {
			this.title = title;
			this.content = content;
			this.author = author;	
		}
		
		private void edit(String newContent) {
			this.content = newContent;
		}
		private void changeAuthor(String newAuthor) {
			this.author = newAuthor;
		}
		private void rename(String newTitle) {
			this.title = newTitle;
		}
		
		@Override
		public String toString() {
			return String.format("%s - %s: %s", this.title, this.content, this.author);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] initialStats = sc.nextLine().split(", ");
		
		Article article = new Article(initialStats[0], initialStats[1], initialStats[2]);
		
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < n; i++) {
			String[] command = sc.nextLine().split(": ");
			
			switch(command[0]) {
				case "Edit": {
					article.edit(command[1]);
				}
				break;
				case "ChangeAuthor": {
					article.changeAuthor(command[1]);
				}
				break;
				case "Rename": {
					article.rename(command[1]);
				}
				break;
			}
		}
		System.out.println(article.toString());
		sc.close();

	}

}
