import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {

	static int T, N, L, calsum, tastesum, result;
	static int[] taste;
	static int[] cal;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			L = scann.nextInt();
			taste = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				taste[i] = scann.nextInt();
				cal[i] = scann.nextInt();
			}
			calsum = 0;
			tastesum = 0;
			result = 0;
			sumSet(0, 0);
			System.out.println(result);
		}
	}

	private static void sumSet(int cnt, int start) {

		if (calsum <= L) {
			result = Math.max(result, tastesum);
		}else {
			return;
		}

		for (int i = start; i < N; i++) {
			calsum += cal[i];
			tastesum += taste[i];
			isSelected[i]=true;
			sumSet(cnt + 1, i + 1);
			isSelected[i]=false;
		}
	}

}
