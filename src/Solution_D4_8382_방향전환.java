import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_8382_방향전환 {

	static int T, result, x1, y1, x2, y2;
	static boolean goWidth; // 가로로 움직였는가
	static int[] dr = {-1, 1, 0, 0}; // 세로2 가로2
	static int[] dc = { 0, 0, 1,-1};
	static int[][] map = new int[201][201];
	static Queue<int[]> move = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			x1 = scann.nextInt();
			y1 = scann.nextInt();
			x2 = scann.nextInt();
			y2 = scann.nextInt();
			map[x1][y1]=1;
			move.offer(new int[] {x1, x2, 0});
			bfs();
			System.out.println("#"+t+" "+result);
		}
		
	}
	private static void bfs() {
		while(!move.isEmpty()) {			
			int r = move.peek()[0];
			int c = move.peek()[1];
			int step = move.poll()[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<-100 || nr>100 || nc<-100 || nc>100 || map[nr][nc]==1) continue;
				if(nr!=x2 || nc!=y2) {
					map[nr][nc] = 1;
					
				}
			}
		}
	}

}
