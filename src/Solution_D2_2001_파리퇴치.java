import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {

	static int T, N, M, result;
	static int[][] field;
	static int[][] pari;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			field = new int[N][N];
			pari = new int[M][M];
			result = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					kill(i,j);
				}
			}
			System.out.println("#"+t+" "+result);
		}
		
		

	}
	private static void kill(int r, int c) {
		int total=0;
		for (int i = r; i < r+M; i++) {
			for (int j = c; j < c+M; j++) {
				total += field[i][j];
			}
			if (total > result) {
				result = total;
			}
		}
	}

}
