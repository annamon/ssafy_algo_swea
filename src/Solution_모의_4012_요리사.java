import java.util.Scanner;

public class Solution_모의_4012_요리사 {

	static int T, N;
	static int answer;
	static int[][] synergy;
	static boolean[] select;
	static int[] a;
	static int[] b;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			select = new boolean[N];
			a = new int[N/2];
			b = new int[N/2];
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					synergy[i][j] = scann.nextInt();
				}
			}
			answer = Integer.MAX_VALUE;
			cook(0,0);
			System.out.println("#"+t+" "+answer);
		}
	}
	private static void cook(int cnt, int start) {
		if(cnt==N/2) {
			int num=0;	// b 목록 만들기
			for (int i = 0; i < N; i++) {
				if(!select[i]) b[num++] = i;
			}
			int aTaste = 0;	// a 맛
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					aTaste += synergy[a[i]][a[j]];
				}
			}
			int bTaste = 0; // b 맛
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					bTaste += synergy[b[i]][b[j]];
				}
			}
			answer = Math.min(answer, Math.abs(aTaste - bTaste));
			return;
		}
		for (int i = start; i < N; i++) {
			if(select[i]==true) continue;
			select[i] = true;
			a[cnt] = i;
			cook(cnt+1, i+1);
			select[i] = false;
		}
		
	}

}
