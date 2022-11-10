package textProcessing;

import java.util.Scanner;

public class ExtractFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		String name = "", extension = "";
		boolean isExtension = true;
		for(int i = path.length()-1; i >=0; i--) {
			if(path.charAt(i) == '.') isExtension = false;
			else if(path.charAt(i) == '\\') break;
			
			if(isExtension)extension+=path.charAt(i);
			else name += path.charAt(i);
		}
		System.out.println("File name: " + reverse(name));
		System.out.println("File extension: " + reverse(extension));
		sc.close();
	}
	
	private static String reverse(String str) {
		String ans = "";
		for(int i = str.length()-1; i >= 0; i--) {
			ans += str.charAt(i);
		}
		return ans;
	}

}
