import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Solution_D2_2005_파스칼의삼각형 {

	static int T;
	static int[] B;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		for (int n = 1; n <= N; n++) {
			T = scann.nextInt();
			System.out.println("#"+n);
			for (int t = 1; t <= T; t++) {
				if (t == 1) {
					System.out.println(1);
				} else if (t == 2) {
					System.out.println("1 1");
					B = new int[t];
					B[0] = 1;
					B[t - 1] = 1;
				} else {
					int[] A = new int[t];
					A[0] = 1;
					A[t - 1] = 1;
					System.out.print(A[0] + " ");
					for (int j = 1; j < t - 1; j++) {
						A[j] = B[j - 1] + B[j];
						System.out.print(A[j] + " ");
					}
					System.out.println(A[t - 1]);
					B = A;
				}
			}
		}
	}
}
