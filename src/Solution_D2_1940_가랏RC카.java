import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 {

	static int T, N, mode;
	static int speed, distance;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();

		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			distance = 0;
			speed = 0;
			for (int n = 0; n < N; n++) {
				mode = scann.nextInt();
				switch (mode) {
				case 0:		// 0이면 속도 변화 x
					break;
				case 1: 	// 1이면 가속도만큼 더하기
					speed += scann.nextInt();
					break;
				case 2:		// 2이면 가속도만큼 빼기
					speed -= scann.nextInt();
					if (speed < 0) 		// 근데 뺐는데 0이하다?
						speed = 0;		// 차 속도는 최소 0 ㄱㄱ
					break;
				default:
					break;
				}
				distance += speed;		// 거리 += 시간*속도 / 어차피 시간 1초
			}
			System.out.println("#" + t + " " + distance);
		}
	}

}
