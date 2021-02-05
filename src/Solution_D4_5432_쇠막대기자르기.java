import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_5432_쇠막대기자르기 {

	static int T;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int count=0;
			Stack<Character> stick = new Stack<Character>();
			String st = scann.next();
			for (int i = 0; i < st.length(); i++) {
				if(st.charAt(i)=='(') {
					stick.push(st.charAt(i));
				}
				else if(st.charAt(i)==')'){
					if(st.charAt(i-1)=='(') { // ) 다음에 ) 가 오면
						stick.pop();
						count += stick.size();
					}else {
						stick.pop();
						count += 1;
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
