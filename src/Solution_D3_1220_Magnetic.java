import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {

	static int T;
	static int[] Array;  // 열만 보자
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			Array = new int[T];
			result = 0;
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());  // 한 줄씩 읽어들여서
				for (int j = 0; j < T; j++) {
					int a = Integer.parseInt(st.nextToken());  // 한 토큰씩 비교
					if (a == 1) {		// 토큰이 1: N극이면
						Array[j] = a;   // 배열에 1 넣기
					}
					else if (a == 2 && Array[j]==1) {	// 토큰이 2: S극이고, 배열에 1이 있으면
						result++;						// 1,2 만나는 거니까 교착상태 +1
						Array[j]=2;						// 배열에 2 넣기
					}
					else continue;		// 0인 경우엔 배열 변화 x
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
