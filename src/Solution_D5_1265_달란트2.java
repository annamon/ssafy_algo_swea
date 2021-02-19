import java.util.Scanner;

public class Solution_D5_1265_달란트2 {

	static int T, talent, bundle, n;
	static long candy;
	static int[] choose;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			talent = scann.nextInt();
			bundle = scann.nextInt();
			candy = 1;
			n = talent / bundle;
			choose = new int[bundle];
			for (int i = 0; i < bundle; i++) {
				choose[i] = n;
			}
			for (int i = 0; i < talent - n*bundle; i++) {
				choose[i]++;
			}
			for (int i = 0; i < bundle; i++) {
				candy *= choose[i];
			}
			System.out.println("#"+t+" "+candy);
		}
	}

}
