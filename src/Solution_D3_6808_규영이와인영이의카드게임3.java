import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임3 {

	static int T, win, lose, gtotal, itotal;
	static boolean[] isSelected = new boolean[18];
	static int[] gyucard = new int[9];
	static int[] incard = new int[9];

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			for (int i = 0; i < 18; i++) { // 선택 초기화
				isSelected[i] = false;
			}
			for (int i = 0; i < 9; i++) {
				int n = scann.nextInt();
				gyucard[i] = n;			// 규영이 카드 받고
				isSelected[n-1]=true;	// 전체 카드 중 규영이가 고른 카드 true 처리
			}
			nPr(0);
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}

	

}
