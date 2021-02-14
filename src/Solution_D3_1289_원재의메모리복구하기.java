import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {

	static int T;

	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			String N = scann.next();
			int count = 0;
			if(N.charAt(0)=='1') count++;
			for (int i = 1; i < N.length(); i++) {
				if(N.charAt(i-1)!=N.charAt(i)) count++;
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
