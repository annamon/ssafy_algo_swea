import java.util.Scanner;

public class Solution_D5_1247_최적경로 {

	static int T, N, answer, distance;
	static int[][] map;
	static int[] order;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map = new int[N+2][2];
			visited = new boolean[N+2];
			order = new int[N+2];
			map[0][0] = scann.nextInt(); // 회사
			map[0][1] = scann.nextInt(); 
			map[N+1][0] = scann.nextInt(); // 집
			map[N+1][1] = scann.nextInt();
			for (int i = 1; i < N+1; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = scann.nextInt();
				}
			}
			order[N+1] = N+1;
			answer = Integer.MAX_VALUE;
			find(1);
			System.out.println("#"+ t + " " + answer);
		}
	}
	
	private static void find(int cnt) {
		if(cnt == N+1) {
			distance = 0;
			for (int i = 1; i <= N+1; i++) {
				int sum = Math.abs(map[order[i-1]][0] - map[order[i]][0])
						+ Math.abs(map[order[i-1]][1] - map[order[i]][1]);
				distance += sum;
			}
			answer = Math.min(answer, distance);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			order[cnt] = i;
			visited[i] = true;
			find(cnt+1);
			visited[i] = false;
		}
	}

}
