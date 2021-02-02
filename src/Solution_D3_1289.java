import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1289 {

	static int T;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			String ss = scann.next();
			int count = 0;
			int[] change = new int[ss.length()];
			for (int i = 0; i < ss.length(); i++) {
				int c = (count+1) % 2;
				if (Character.getNumericValue(ss.charAt(i)) != change[i]) {
					for (int j = i; j < ss.length(); j++) {
						Arrays.fill(change, i, ss.length(), c);
					}
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
