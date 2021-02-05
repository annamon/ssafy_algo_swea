package annaswea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {
	static int N;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <=10; t++) {
			Stack<Character> s = new Stack<Character>();
			N = scann.nextInt();
			String st = scann.next();
			char[] box = new char[N];
			box = st.toCharArray();
			s.push('0'); // 스택 맨 아래 칸을 기본으로 채워주어야 나중에 스택이 다 없어져도 EmptyStackException 발생 안 함
			for (int i = 0; i < N; i++) {
				if((s.peek()==('(') && box[i]==')') 
						|| (s.peek()==('{') && box[i]=='}') 
						|| (s.peek()==('[') && box[i]==']') 
						|| (s.peek()==('<') && box[i]=='>')) {
					s.pop();
				}
				else s.push(box[i]);
			}
			if(s.peek()=='0') {
				System.out.println("#"+t+" "+1);
			}
			else {
				System.out.println("#"+t+" "+0);
			}
		}
		
		
	}

}
