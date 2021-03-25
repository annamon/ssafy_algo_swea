import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열2 {

	static int T, N, answer;
	static int[] arr;
	static int[] list;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			arr = new int[N];
			list = new int[N];
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = scann.nextInt();
			}
			for (int i = 0; i < N; i++) {
				list[i]=1;
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i] && list[i]<list[j]+1) {
						list[i] = list[j]+1;
					}
				}
				answer = Math.max(answer, list[i]);
			}
			System.out.println("#"+t+" "+answer);
		}
	}

}
