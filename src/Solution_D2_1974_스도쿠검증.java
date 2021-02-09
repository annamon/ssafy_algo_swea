
import java.util.Scanner;

public class Solution_D2_1974_스도쿠검증 {

	static int T, sum, result;
	static int[][] sudoku;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			sudoku = new int[9][9];
			result = 1;
			sum = 0;
			for (int i = 0; i < 9; i++) { // 행체크
				sum = 0;
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = scann.nextInt();
					sum += sudoku[i][j];
				}
				if (sum != 55) {
					break;
				}
			}
			
			if (sum != 55) {
				result=0;
			}
			else { // 열체크
				for (int i = 0; i < 9; i++) {
					sum = 0;
					for (int j = 0; j < 9; j++) {
						sum += sudoku[j][i];
					}
					if (sum != 55) {
						break;
					}
				}
				
				if (sum != 55) {
					result=0;
				}
				else { // 칸체크
					sellcheck(0);
					sellcheck(3);
					sellcheck(6);
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

	private static void sellcheck(int num) {
		for (int i = num; i < num + 3; i++) {
			sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += sudoku[i][j];
			}
			if (sum != 55) {
				result = 0;
				break;
			}
			for (int j = 3; j < 6; j++) {
				sum += sudoku[i][j];
			}
			if (sum != 55) {
				result = 0;
				break;
			}
			for (int j = 6; j < 9; j++) {
				sum += sudoku[i][j];
			}
			if (sum != 55) {
				result = 0;
				break;
			}
		}
	}

}
