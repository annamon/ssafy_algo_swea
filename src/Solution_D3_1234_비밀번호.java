import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234_비밀번호 {

	static int T;
	static String pw;
	static Stack<Character> password = new Stack<>();

	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(scann.next());
			pw = scann.next();
			for (int i = 0; i < pw.length(); i++) {
				if (!password.empty() && password.peek() == pw.charAt(i))
					password.pop();
				else {
					password.push(pw.charAt(i));
				}
			}
			StringBuilder answer = new StringBuilder("");
			while (!password.empty()) {
				answer.insert(0, password.pop());
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
