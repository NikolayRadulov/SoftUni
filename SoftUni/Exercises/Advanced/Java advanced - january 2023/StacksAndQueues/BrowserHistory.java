package module3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

	public BrowserHistory() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = sc.nextLine();
		ArrayDeque<String> stack = new ArrayDeque<>();
		while(!url.equals("Home")) {
			if(url.equals("back")) {
				if(stack.size() <= 1) System.out.println("no previous URLs");
				else {
					stack.pop();
					System.out.println(stack.peek());					
				}
			}
			else {
				stack.push(url);
				System.out.println(url);
			}
			url = sc.nextLine();
		}
		sc.close();
	}

}
