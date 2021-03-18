import java.util.Scanner;

public class Solution_D4_1486_장훈이의높은선반 {

	static int T, N, B, answer;
	static int[] height;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {			
			N = scann.nextInt();
			B = scann.nextInt();
			height = new int[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				height[i] = scann.nextInt();
			}
			top(0,0);
			System.out.println("#"+t+" "+answer);
		}
	}
	private static void top(int count, int sum) {
		if(count==N) {
			if(sum >= B) answer = Math.min(answer, sum-B);
			return;
		}
		top(count+1, sum + height[count]);
		top(count+1, sum);
	}

}
