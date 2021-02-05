import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {

	static int T;
	static int[] num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Queue<Integer> q = new LinkedList<Integer>();
			T = scann.nextInt();
			num = new int[8];
			for (int i = 0; i < 8; i++) {
				q.offer(num[i]=scann.nextInt());
			}
			while (!q.contains(0)) {
				for (int j = 1; j <= 5; j++) {
					if (q.peek() - j <= 0) {
						q.offer(0);
						q.poll();
						break;
					} else {
						q.offer(q.peek() - j);
						q.poll();
					}
				}
			}
			System.out.print("#"+t+q);
			System.out.println();
			System.out.println();
		}

	}

}
