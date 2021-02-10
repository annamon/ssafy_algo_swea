import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {

	static int T, N, M, sum, result;
	static int[] snack;
	static int[] choice = new int[2];
	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			M = scann.nextInt();
			snack = new int[N]; 
			for (int n = 0; n < N; n++) {
				snack[n] = scann.nextInt();
			}
			result = 0;
			sum = 0;
			nC2(0,0);
			if(result==0) {
				System.out.println("#"+t+" -1");
			}else {
				System.out.println("#"+t+" "+ result);
			}
		}
	}
	
	private static void nC2(int cnt, int start) {
		if(cnt == 2) {
			sum = choice[0] + choice[1];
			if (sum<=M) {
				result = Math.max(result, sum);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = snack[i];
			nC2(cnt+1, i+1);
		}
	}

}
