import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임2 {

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
			nPr(0,0);
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}

	private static void nPr(int cnt, int flag) {
		if(cnt==9) {
			gtotal = 0;	// 규영 총합
			itotal = 0; // 인영 총합
			for (int i = 0; i < 9; i++) {
				if(gyucard[i]>incard[i]) {	// 규영이 카드 숫자가 더 크면
					gtotal += gyucard[i]+incard[i];	// 규영이 점수 ㄱㄱ
				}else {
					itotal += gyucard[i]+incard[i];	// 아니면 인영이 ㄱㄱ
				}
			}
			if(gtotal>itotal) {	// 총점이 규영이가 더 크면
				win++;			// 규영이 이긴거임
			}else if(gtotal<itotal){
				lose++;			// 아니면 진거임
			}
			return;
		}
		for (int i = 0; i < 18; i++) {
			if((flag & (1<<i))!=0) continue;
			incard[cnt] = i+1;			// 인영이 카드 받아 ㄱㄱ
			nPr(cnt+1, flag|(1<<i));
		}
	}

}
