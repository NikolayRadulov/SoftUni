package multyDimentionalArrays;

import java.util.Scanner;

public class HeiganDance {

	private static class Player {
		private int hitPoints = 18500;
		private int i = 7;
		private int j = 7;
		private boolean cloudToHit = false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[15][15];
		Player player = new Player();
		double heiganHitpoints = 3000000;
		double damagePerTurn = Double.parseDouble(sc.nextLine());
		String lastSpell = "";
		while (true) {		
			heiganHitpoints-=damagePerTurn;
		    
		    if(player.cloudToHit) {
				player.hitPoints-=3500;
				player.cloudToHit = false;
				if(player.hitPoints <= 0) break;
			}		
			if(heiganHitpoints <= 0) break;
			
			String tokens[] = sc.nextLine().split("\\s+");			
			int i = Integer.parseInt(tokens[1]);
			int j = Integer.parseInt(tokens[2]);	    									
			
			hit(matrix, i, j, player);
			
			if(matrix[player.i][player.j] != 0) {
				if(!move(matrix, player)) {
					if(tokens[0].equals("Cloud")) {
						player.hitPoints-=3500;
						player.cloudToHit = true;
						lastSpell = "Plague Cloud";
					}
					else {
						player.hitPoints-=6000;
						lastSpell = "Eruption";
					}
				}
			}			
			endTurn(matrix);	
			if(player.hitPoints <= 0) break;
		}
		if (heiganHitpoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHitpoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (player.hitPoints > 0) {
            System.out.printf("Player: %d%n", player.hitPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
 
        System.out.println("Final position: " + player.i + ", " + player.j);
		sc.close();
	}
	
	private static void endTurn(int[][] matrix) {	
		for (int j2 = 0; j2 < matrix.length; j2++) {
			for (int k = 0; k < matrix.length; k++) {
				if(matrix[j2][k] > 0)matrix[j2][k]--;
			}
		}
	}
	
	private static boolean move(int[][] matrix, Player player) {
		if(player.i-1 >= 0 && matrix[player.i-1][player.j] == 0) {
			player.i--;
			return true;
		}
		if(player.j+1 < 15 && matrix[player.i][player.j+1] == 0) {
			player.j++;
			return true;
		}
		if(player.i+1 < 15 && matrix[player.i+1][player.j] == 0) {
			player.i++;
			return true;
		}
		if(player.j-1 >= 0 && matrix[player.i][player.j-1] == 0) {
			player.j--;
			return true;
		}
		return false;
	}
	
	private static void hit(int[][] matrix, int i, int j, Player player) {
		for (int k = i-1; k <= i+1; k++) {
			for (int k2 = j-1; k2 <= j+1; k2++) {
				if(isValid(k, k2)) {
					matrix[k][k2] = 1;
				}
			}
		}	
	}

	private static boolean isValid(int i, int j) {
		return (i >= 0 && i < 15 && j >= 0 && j < 15);
	}
}
