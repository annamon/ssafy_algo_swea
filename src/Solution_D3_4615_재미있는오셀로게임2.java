
import java.util.Scanner;

// 재미 한개도 없는 오셀로임;
public class Solution_D3_4615_재미있는오셀로게임2 {
	static int T;
	static int N, M;
	static int[][] o;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int r, c, egg;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			o = new int[N + 2][N + 2];
			M = sc.nextInt();

			o[N / 2][N / 2] = 2;
			o[N / 2 + 1][N / 2 + 1] = 2;
			o[N / 2][N / 2 + 1] = 1;
			o[N / 2 + 1][N / 2] = 1;

			int r = 0;
			int c = 0;
			int egg = 0;

			for (int i = 0; i < M; i++) {

				r = sc.nextInt();
				c = sc.nextInt();
				egg = sc.nextInt();
				Oselo(r, c, egg);
			}

			int black = 0;
			int white = 0;

			for (int i = 0; i < o.length; i++) {
				for (int j = 0; j < o.length; j++) {
					if (o[i][j] == 1)
						black++;
					else if (o[i][j] == 2)
						white++;
				}
			}

			System.out.println("#" + t + " " + black + " " + white);

		}
	}

	private static void Oselo(int r, int c, int egg) {
		int d = 0;
		int nr = 0;
		int nc = 0;

		for (d = 0; d < 8; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			while (isIn(nr, nc)) {
				if (o[nr][nc] == 0) 
					break; // 오류 원인이었음 : 돌이 아무것도 없으면 그냥 넘어간다.
				// 나와 같은 색의 돌을 만나는 동안 계속 탐색
				if (o[nr][nc] == egg) {
					o[r][c] = egg;
					while (true) {
						if (nr == r && nc == c)
							break;
						if (o[nr][nc] != 0)
							o[nr][nc] = egg; // 돌이 있는 자리만 바꿔줘야함
						nr -= dr[d];
						nc -= dc[d];
					}
					break;
				}
				nr += dr[d];
				nc += dc[d];
			}
		}

	}

	// 탐색 범위 체크
	private static boolean isIn(int r, int c) {
		if (r >= 1 && r <= N && c >= 1 && c <= N)
			return true;
		return false;
	}

}