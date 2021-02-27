import java.util.Scanner;

public class Solution_D3_4615_재미있는오셀로게임 {

	static int T, N, M;
	static int[][] othello;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			M = scann.nextInt();
			othello = new int[N][N];
			othello[N / 2 - 1][N / 2 - 1] = 2;
			othello[N / 2 - 1][N / 2] = 1;
			othello[N / 2][N / 2 - 1] = 1;
			othello[N / 2][N / 2] = 2;

			for (int i = 0; i < M; i++) {
				int c = scann.nextInt() - 1;
				int r = scann.nextInt() - 1;
				int color = scann.nextInt();
				if (othello[r][c] != 0)
					continue;
				othello[r][c] = color;
				find(r, c, color);
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {
						System.out.print(othello[x][y]);
					}
					System.out.println();
				}
				System.out.println();
			}

			int white = 0;
			int black = 0;
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if (othello[a][b] == 1)
						black++;
					if (othello[a][b] == 2)
						white++;
				}
			}
			System.out.println("#" + t + " " + black + " " + white);
		}
	}

	private static void find(int r, int c, int color) {
		int nr=0;
		int nc=0;
		for (int i = 0; i < 8; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			while(isIn(nr, nc)) { // 돌 놓은 놈 주변 a 탐색, 배열 범위 안에 있으면
				if (othello[nr][nc] == 0) // 그리고 그 a 자리에 같은 색이거나 0이면 패스
					break;
				if (othello[nr][nc] == color){
					while (true) { // 같은색이 나올때까지 같은방향 계속 가기
						if(nr==r && nc==c) break;
						if(othello[nr][nc]!=0) othello[nr][nc]=color;
						nr -= dr[i];
						nc -= dc[i];
					}
					break;
				}
				nr+=dr[i];
				nc+=dc[i];
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		else return false;
	}
}