package stacksAndQueus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

	public BalancedParentheses() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		String input = sc.nextLine();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
			else if(ch == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					System.out.println("NO");
					sc.close();
					return;
				}
			}
			else if(ch == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					System.out.println("NO");
					sc.close();
					return;
				}
			}
			else if(ch == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					System.out.println("NO");
					sc.close();
					return;
				}
			}
		}
		System.out.println("YES");
		
		sc.close();

	}

}
