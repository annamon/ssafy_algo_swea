import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_D2_1974_스도쿠검증2 {

	static int T, sum, result;
	static int[][] sudoku = new int[9][9];
	static Set<Integer> sudokuCheck = new HashSet<>();

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = scann.nextInt();
				}
			}
			result = 1;
			check();
			System.out.println("#"+t+" "+result);
		}
	}

	private static void check() {
		for (int i = 0; i < 9; i++) {
			sudokuCheck.clear();
			for (int j = 0; j < 9; j++) {
				sudokuCheck.add(sudoku[i][j]);
			}
			if(sudokuCheck.size()!=9) {
				result=0;
				return;
			}
		}
		for (int i = 0; i < 9; i++) {
			sudokuCheck.clear();
			for (int j = 0; j < 9; j++) {
				sudokuCheck.add(sudoku[j][i]);
			}
			if(sudokuCheck.size()!=9) {
				result=0;
				return;
			}
		}
		for (int i = 0; i < 3; i++) {
			sudokuCheck.clear();
			for (int j = 0; j < 3; j++) {
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						sudokuCheck.add(sudoku[3*i+x][3*j+y]);
					}
				}
				if(sudokuCheck.size()!=9) {
					result=0;
					return;
				}
			}
		}
	}
}
