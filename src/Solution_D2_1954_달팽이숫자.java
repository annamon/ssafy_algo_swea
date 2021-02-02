import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T, N;
	static int[][] snail;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			snail = new int[N][N];
			int num=0, r=0, c=0;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(snail[i], 0);
			}
			for (int i = 1; i <= N * N; i++) {
				snail[r][c] = i;
				if(r+dr[num%4]==N || r+dr[num%4]==-1 || c+dc[num%4]==N || c+dc[num%4]==-1 
						|| snail[r+dr[num%4]][c + dc[num % 4]]!=0) {
					num++;
				}
					r = r + dr[num % 4];
					c = c + dc[num % 4];
			}
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}