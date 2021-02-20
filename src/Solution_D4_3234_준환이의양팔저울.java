import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

	// 전역변수 ㄴㄴㄴㄴㄴㄴㄴㄴ 지역변수 ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ
	static int T, total;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] weight = new int[N];
			boolean[] isSelected = new boolean[N];
			total = 0;	// 결과 가지수
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			balance(0,0,0, N, weight, isSelected);
			System.out.println("#"+t+" "+total);
		}
	}
	private static void balance(int cnt, int lweight, int rweight, int N, int[] weight, boolean[] isSelected) {
		if(lweight < rweight) return;
		if(cnt==N) {
			total++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			balance(cnt+1, lweight + weight[i], rweight, N, weight, isSelected);
			balance(cnt+1, lweight, rweight + weight[i], N, weight, isSelected);
			isSelected[i] = false;
		}
		
	}
	

}
