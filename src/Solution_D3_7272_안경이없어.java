import java.util.Scanner;

public class Solution_D3_7272_안경이없어 {

	static int T;
	static String left, right;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=Integer.parseInt(scann.next());
		for (int t = 1; t <= T; t++) {
			left = scann.next();
			right = scann.next();
			int L=0;
			int R=0;
			String answer=" SAME";
			if(left.length()!=right.length()) {
				System.out.println("#"+t+" DIFF");
				continue;
			}
			for (int i = 0; i < left.length(); i++) {
				if(left.charAt(i)=='A' || left.charAt(i)=='D'||
						left.charAt(i)=='O'|| left.charAt(i)=='P'||
						left.charAt(i)=='Q'|| left.charAt(i)=='R') {
					L=1;
				}else if(left.charAt(i)=='B') {
					L=2;
				}else L=0;
				if(right.charAt(i)=='A' || right.charAt(i)=='D'||
						right.charAt(i)=='O'|| right.charAt(i)=='P'||
						right.charAt(i)=='Q'|| right.charAt(i)=='R') {
					R=1;
				}else if(right.charAt(i)=='B') {
					R=2;
				}else R=0;
				if(L!=R) {
					answer=" DIFF";
					break;
				}
			}
			System.out.println("#"+t+answer);
		}
	}

}
