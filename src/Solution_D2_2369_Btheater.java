import java.util.Scanner;

public class Solution_D2_2369_Btheater {

	public static void main(String[] args) {
		int T;
		int total=0;
		int[] seat = new int[2];
		Scanner scann= new Scanner(System.in);
		T = scann.nextInt(); //�׽�Ʈ���̽� ��ҷ�
		for(int t=1; t<=T; t++) {
			int count = scann.nextInt(); //���ٳ�����
			for (int i = 0; i < count; i++) { //�Է¤���
				seat[0] = scann.nextInt();
				seat[1] = scann.nextInt();
				int man = seat[1]-seat[0]+1;
				total += man;
			}
			System.out.println("#" + t + " " + total);
			total = 0;
		}
	}
}