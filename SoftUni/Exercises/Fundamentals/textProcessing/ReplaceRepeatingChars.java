package textProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String ans = "";
		ans += text.charAt(0);
		int ansIndex = 0;
		for(int i = 1; i < text.length(); i++) {
			if(ans.charAt(ansIndex) == text.charAt(i)) continue;
			ans += text.charAt(i);
			ansIndex++;
		}
		System.out.println(ans);
		sc.close();
	}

}
