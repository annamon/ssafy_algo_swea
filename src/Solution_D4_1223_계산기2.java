import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {

	static int N, result;
	static char[] calcu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			calcu = new char[N];
			String st = br.readLine();
			for (int i = 0; i < st.length(); i++) {
				calcu[i] = st.charAt(i);
			}
			Stack<Integer> num = new Stack<>();  // 숫자만 스택에 넣자
			for (int i = 0; i < N; i++) { // 숫자만 스택에 넣자!
				if (i>0 && calcu[i - 1] == '*') {  // 이전 값이 *면
					num.push(num.pop() * (calcu[i]-'0')); // 스택 맨 위 꺼내서 지금 값이랑 곱하고 다시 스택에 넣자
				}
				else if (calcu[i] == '+' || calcu[i] == '*') { // + 나 *는 스택에 넣지 말기
					continue;
				}
				else { // 숫자면 스택에 넣기
					num.push(calcu[i] - '0');
				}
			}
			result = 0;
			
			while (!num.isEmpty()) {
				result += num.pop(); // 스택에 들어있는 거 다 꺼내서 더해주기
			}
			System.out.println("#"+t+" "+result);
		}

	}

}
