import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1227_미로2 {

	static char[][] maze;
	static boolean[][] visited;
	static int sr, sc;
	static boolean canGO;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0,-1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			maze = new char[100][100];
			visited = new boolean[100][100];
			canGO = false;
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = line.charAt(j);
					if(maze[i][j]=='2') {
						sr=i;
						sc=j;
					}
				}
				find(sr, sc);
			}
			
			System.out.println("#"+T+" "+(canGO? 1:0));
			
		}
	}
	private static void find(int r, int c) {
		if(maze[r][c]=='3') {
			canGO = true;
			return;
		}
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<100 && nc>=0 && nc<100 && !visited[nr][nc]) {
				if(maze[nr][nc]!='1') {
					find(nr, nc);				
				}
			}
		}
		visited[r][c] = false;
	}

}
