import java.util.Scanner;

public class Solution_D3_11315_오목판정 {

	static int T, N, count;
	static String om;
	static char[][] omok;
	
	public static void main(String[] args)  {
		Scanner scann = new Scanner(System.in);
		T = Integer.parseInt(scann.nextLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(scann.nextLine());
			omok = new char[N][N];
			String result = "NO";
			for (int n = 0; n < N; n++) {
				om = scann.nextLine();
				for (int i = 0; i < N; i++) {
					omok[n][i] = om.charAt(i);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(omok[i][j]=='o') {
						if(find(i,j,N)) {
							result = "YES";
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
		
		
	}
	private static boolean find(int r, int c, int N) {
//		상,하,좌,우,북동,남서,북서,남동
//		dr = {-1,1,0,0, -1,1,-1,1};
//		dc = {0,0,-1,1, 1,-1,-1,1};
		count=1;
		for (int i = r-1; i >= 0; i--) { //상
			if(count==5) return true;
			if(omok[i][c]=='o') count++;
			else break;
		}
		for (int i = r+1; i<N; i++) { //하
			if(count==5) return true;
			if(omok[i][c]=='o') count++;
			else break;
		}
		if(count==5) return true;
		count=1;
		for (int i = c-1; i >= 0; i--) { //좌
			if(count==5) return true;
			if(omok[r][i]=='o') count++;
			else break;
		}
		for (int i = c+1; i<N; i++) { //우
			if(count==5) return true;
			if(omok[r][i]=='o') count++;
			else break;
		}
		if(count==5) return true;
		count=1;
		
		for (int i = 1; i <= N/2; i++) { //북동
			if(count==5) return true;
			int nr = r -i;
			int nc = c + i;
			if(nr<0 || nr>=N || nc<0|| nc>=N) break;
			if(omok[nr][nc]=='o') count++;
			else break;
		}
		for (int i = 1; i <= N/2; i++) { //남서
			if(count==5) return true;
			int nr = r+i;
			int nc = c-i;
			if(nr<0 || nr>=N || nc<0|| nc>=N) break;
			if(omok[nr][nc]=='o') count++;
			else break;
		}
		if(count==5) return true;
		count=1;
		for (int i = 1; i <= N/2; i++) { //북서
			if(count==5) return true;
			int nr = r -i;
			int nc = c -i;
			if(nr<0 || nr>=N || nc<0|| nc>=N) break;
			if(omok[nr][nc]=='o') count++;
			else break;
		}
		for (int i = 1; i <= N/2; i++) { //남서
			if(count==5) return true;
			int nr = r +i;
			int nc = c +i;
			if(nr<0 || nr>=N || nc<0|| nc>=N) break;
			if(omok[nr][nc]=='o') count++;
			else break;
		}
		if(count==5) return true;
		return false;
	}
}