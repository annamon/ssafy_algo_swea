import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {

	static int T, H, W, go; // go : 탱크 작동 몇번?
	static int r, c;	// 탱크 위치
	static String set;  // 필드 세팅, 탱크 작동 세팅
	static char d;		// 탱크 방향
	static char[] run;  // 탱크 작동
	static char[][] field; // 배틀필드

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			H = scann.nextInt();
			W = scann.nextInt();
			scann.nextLine();
			field = new char[H][W];
			for (int i = 0; i < H; i++) { // 배틀필드 채우기
				set = scann.nextLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = set.charAt(j);
				}
			}
			go = scann.nextInt();
			scann.nextLine();
			run = new char[go];
			set = scann.nextLine();
			for (int i = 0; i < go; i++) { // 탱크 명령 받기
				run[i] = set.charAt(i);
			}
			for (int i = 0; i < H; i++) {  // 탱크 찾기
				for (int j = 0; j < W; j++) {
					if (field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
						r = i;
						c = j;
						d = field[i][j];
						break;
					}
				}
			}
			for (int i = 0; i < go; i++) { // 탱크 명령 수행 ㄱ
				game(i, H, W);
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 탱크 명령 수행
	private static void game(int i, int H, int W) {
		switch (run[i]) {
		case 'U':
			if (r - 1 >= 0 && field[r - 1][c] == '.') {
				field[r][c] = '.';
				r = r - 1;
			}
			field[r][c] = '^';
			d = field[r][c];
			break;
		case 'D':
			if (r + 1 < H && field[r + 1][c] == '.') {
				field[r][c] = '.';
				r = r + 1;
			}
			field[r][c] = 'v';
			d = field[r][c];
			break;
		case 'L':
			if ( c - 1 >= 0 && field[r][c - 1] == '.') {
				field[r][c] = '.';
				c = c - 1;
			}
			field[r][c] = '<';
			d = field[r][c];
			break;
		case 'R':
			if (c+1<W && field[r][c + 1] == '.') {
				field[r][c] = '.';
				c = c + 1;
			}
			field[r][c] = '>';
			d = field[r][c];
			break;
		case 'S':
			shoot(r, c);
		default:
			break;
		}
	}

	private static void shoot(int r, int c) {
		switch (d) {
		case '^':
			for (int i = r-1; i >= 0; i--) {
				if (i >= 0 && field[i][c] == '*') {
					field[i][c] = '.';
					break;
				} else if (field[i][c] == '#') break;
			}
			break;
		case 'v':
			for (int i = r+1; i < H; i++) {
				if (i < H  && field[i][c] == '*') {
					field[i][c] = '.';
					break;
				} else if (field[i][c] == '#') break;
			}
			break;
		case '<':
			for (int i = c-1 ; i >= 0; i--) {
				if (i >= 0 &&  field[r][i] == '*') {
					field[r][i] = '.';
					break;
				} else if (field[r][i] == '#') break;
			}
			break;
		case '>':
			for (int i = c+1 ; i < W; i++) {
				if (i < W && field[r][i] == '*') {
					field[r][i] = '.';
					break;
				} else if (field[r][i] == '#') break;
			}
			break;
		default:
			break;
		}
	}
}
