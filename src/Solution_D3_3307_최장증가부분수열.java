package annaswea;

import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열 {

	static int T;
	static int N;
	static int a;
	static int[] number;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			number = new int[N];
			int result = 0;
			for (int i = 0; i < N; i++) {
				number[i] = scann.nextInt();
			}
			for (int i = 0; i < N; i++) {
				int count=0;
				a = number[i];
				for (int j = i+1; j <N ; j++) {
					if(a<number[j]) {
						count++;
						a = number[j];
					}
				}
				System.out.println(count);
				result = count>result? count: result;
			}
			System.out.println("#"+t+" "+result);
		}

	}

}
