import java.util.Scanner;
public class Solution_D2_1926_간단한369게임 {

	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 1; i < N+1; i++) {
			do369(i);
		}
	}
	
	public static void do369(int i) {
		int a = 0;
		int b = 0;
		int count = 0;
		b = i;
		while(b>10) { // 뒤부터 체크하기  ex)451
			a = b%10; // 첫턴 a=1 / 두번째턴 a=5
			b = b/10; // 첫턴 b=45 / 두번째턴 b=4
			if((a==3)||(a==6)||(a==9)) { //a가 3,6,9인지 체크
				count++;
			}
		}
		if((b==3)||(b==6)||(b==9)) {
			count++;
		} // 맨 앞자리가 3,6,9인 경우
		switch(count) {
			case 0: System.out.print(i+" "); break;
			case 1: System.out.print("- "); break;
			case 2: System.out.print("-- "); break;
			case 3: System.out.print("--- "); break;
		}
	}
}
