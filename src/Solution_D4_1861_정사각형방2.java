package annaswea;

import java.util.Scanner;

public class Solution_D4_1861_정사각형방 {

	static int T, N, roomCount, roomNum;
	static int[][] room;
	static int[][] moving;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			room = new int[N][N];
			moving = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = scann.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(moving[i][j]==0)
						find(i, j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(moving[i][j]);
				}
				System.out.println();
			}
			roomCount = 0;
			roomNum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (moving[i][j] > roomCount) {
						roomCount = moving[i][j];
						roomNum = room[i][j];
					} else if (moving[i][j] == roomCount && room[i][j] < roomNum) {
						roomNum = room[i][j];
					}

				}
			}
			System.out.printf("#%d %d %d\n", t, roomNum, roomCount);
		}

	}

	private static void find(int r, int c) {
		moving[r][c] =  1;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (room[nr][nc] == room[r][c] + 1) {
				if(moving[nr][nc]==0)
					find(nr, nc);
				if(moving[r][c] < moving[nr][nc]+1)
					moving[r][c] = moving[nr][nc] +1;
			}
		}
	}

}
