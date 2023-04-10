package module3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class QueueExersise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringBuilder string = new StringBuilder();
		ArrayDeque<String> queue = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
			switch(tokens[0]) {
				case "1": {
					string.append(tokens[1]);
					queue.addFirst("1" + tokens[1]);
				}
				break;
				case "2": {
					int count = Integer.parseInt(tokens[1]);
					String deleted = string.substring(string.length()-count, string.length());
					string.delete(string.length()-count, string.length());
					queue.addFirst("2" + deleted);
				}
				break;
				case "3": {
					System.out.println(string.charAt(Integer.parseInt(tokens[1])-1));
				}
				break;
				case "4": {
					String oper = queue.poll();
					if(oper.startsWith("1")) {
						String str = oper.substring(1);
						string.delete(string.lastIndexOf(str), string.length());
					}
					else if(oper.startsWith("2")) {
						String str = oper.substring(1);
						string.append(str);
					}
				}
				break;
			}
			
		}
		sc.close();
	}
	

}
