import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1238_Contact {

	static int[][] contact;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = scann.nextInt();
			int start = scann.nextInt();
			contact = new int[101][101]; // 연락망, 0은 안 쓸 거니까 100+1
			visited = new int[101];		 // 방문표시
			visited[start] = 1; // 시작넘 방문표시 ㄱㄱ
			for (int i = 0; i < N/2; i++) {
				contact[scann.nextInt()][scann.nextInt()] = 1; // 연락망 채워주기(유향) from - to
			}
			q.offer(start); // 시작놈 큐에 넣기
			int last = 1;
			while(!q.isEmpty()) {
				int now = q.poll(); // 큐에서 현재 연락돌릴놈 꺼내기
				for (int i = 1; i < 101; i++) {
					if(contact[now][i]==0 || visited[i]!=0) continue; // 연락할 수 없거나 이미 누가 연락했으면 패스
					q.offer(i); // 연락 목록에 넣기
					visited[i] = visited[now]+1;	   // 몇번째로 왔는지 넣기
					last = Math.max(visited[i], last); // 젤 마지막 순서 기억
				}
			}
			int answer = 0;
			for (int i = 1; i < 101; i++) {
				if(visited[i]==last) {					
					answer = Math.max(i, answer); // 마지막 순서로 온 넘들 중에 번호 제일 큰 놈 찾기
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}

}
