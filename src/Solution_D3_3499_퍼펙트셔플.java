import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플 {

	static int T, N;
	static String[] shuffle;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			shuffle = new String[N];
			for (int i = 0; i < N; i++) {
				shuffle[i] = scann.next();
			}
			System.out.print("#" + t);
			for (int i = 0; i < N / 2; i++) {
				if (N - N / 2 + i < N) { // 반 나눠서 순서대로 보여주자
					System.out.print(" " + shuffle[i]);
					System.out.print(" " + shuffle[N - N / 2 + i]);
				}
			}
			if(N%2==1) { // 하나 남으니까
				System.out.print(" " + shuffle[N/2]);
			}
			System.out.println();
		}
	}

}
