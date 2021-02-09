import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {

	static int N, result;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			result = 1; // 계산가능이면 1
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());	// 한 줄 통으로 읽어서
				if(result == 0) continue; // 0이면 어차피 계산 안됨 패스패스
				int one = Integer.parseInt(st.nextToken());	// 처음 숫자 넘기고
				char two = st.nextToken().charAt(0);		// 그 다음에 들어오는 거
				if(st.hasMoreTokens()) {	// 뒤에 토큰 더 있으면 상관 ㄴㄴ
					continue;
				}
				else if(two == '+' || two == '-' || two == '*' || two == '/') { // 근데 더 없다는데 기호다? 단말노드에 기호나온거임
					result = 0; // 계산불가능 0
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}