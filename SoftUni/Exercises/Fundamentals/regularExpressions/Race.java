package regularExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		Pattern patternName =Pattern.compile("[A-Za-z_]+");
		Pattern patternKm =Pattern.compile("[0-9]");
		Map<String, Integer> map = new LinkedHashMap<>();
		List<String> list = Arrays.stream(sc.nextLine().split(", ")).map(String::valueOf).collect(Collectors.toList());
		
		String command = sc.nextLine();
		while(!command.equals("end of race")) {
			Matcher matcherName = patternName.matcher(command);
			String name = "";
			while (matcherName.find()) {
				name += matcherName.group();
			}
			if(!list.contains(name)) {
				command = sc.nextLine();
				continue;
			}
			Matcher matcherKm = patternKm.matcher(command);
			int km = 0;
			while (matcherKm.find()) {
				km += Integer.parseInt(matcherKm.group());;
			}
			
			if(map.containsKey(name)) map.put(name, map.get(name)+km);
			else map.put(name, km);
			command = sc.nextLine();
		}
		List<String> topThree = findTopThree(map);
		
		System.out.println("1st place: " + topThree.get(0));
		System.out.println("2nd place: " + topThree.get(1));
		System.out.println("3rd place: " + topThree.get(2));
		sc.close();
	}

	private static List<String> findTopThree(Map<String, Integer> map) {
		String maxName = "";
		int max = Integer.MIN_VALUE;
		List<String> names = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			for (Map.Entry<String, Integer> elEntry : map.entrySet()) {
				if(elEntry.getValue()>max && !names.contains(elEntry.getKey())) {
					maxName = elEntry.getKey();
					max = elEntry.getValue();
				}
			}
			max = Integer.MIN_VALUE;
			names.add(maxName);
			maxName = "";
		}
		return names;
	}
}
