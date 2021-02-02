import java.util.Scanner;
import java.util.Arrays;

public class Solution_D2_2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		int M = scann.nextInt();
		int[][] set = new int[N][N];
		int[][] pari = new int[M][M];
		int paris;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				set[i][j] = scann.nextInt();
			}
		}
		for(int x=0; x<N-M; x++) {
				System.arraycopy(set, x, pari, 0, M);
		}
		

	}

}
