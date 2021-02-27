import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {

	static int T, N;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = scann.next();
				char[] sc = s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = sc[j]-'0';
				}
			}
			int r = sum(N);
			System.out.println("#" + t + " "+ r);
		}
	}
	
	private static int sum(int N) {
		int tot=0;
		int d = N/2;
		for (int i = 0; i < N/2; i++) {
			for (int j = d; j < N-d; j++) {
				tot+=map[i][j];
			}
			d--;
		}
		for (int i = N/2; i < N; i++) {
			for (int j = d; j < N-d; j++) {
				tot+=map[i][j];
			}
			d++;
		}
		return tot;
	}

}

