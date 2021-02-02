import java.util.Scanner;

public class Solution_D2_1859_백만장자프로젝트 {

	static int T;
	static int K;
	static long[] num;
	static long[] price;
	public static void main(String[] args) {

		Scanner scann= new Scanner(System.in);
		T = scann.nextInt();  //�׽�Ʈ���̽� 3�Է¹ް�
		price = new long[T];
		for (int t = 0; t < T; t++) { //�׽�Ʈ���̽� 3�� ������
			K = scann.nextInt(); //���̽� ��ĥ���� �ѹ����޾�
			num = new long[K]; //��������ŭ �迭 ����
			for (int k = 0; k < K; k++) {
				num[k]=scann.nextLong(); //�Է¹޾�
			}
			long buy=0; //���
			long count=0; //�� ����
			long sell=0; //�ǸŰ�
			if(num[0]<=num[1]) {
				buy+=num[0];
				count+=1;
			}
			long total=0;
			for (int i = 0; i < K-2; i++) {
				if((num[i]<=num[i+1])&&(num[i+1]<=num[i+2])) {
					buy+=num[i+1];
					count+=1;
				}//<����<
				else if((num[i]<=num[i+1])&&(num[i+1]>num[i+2])){
					sell = num[i+1]*count - buy;
					total+=sell;
					count=0;
					buy=0;
					sell=0;
				}//<�Ǹ�>
				else if((num[i]>num[i+1])&&(num[i+1]>num[i+2])) {
					count+=0;
				}//>�ƹ��͵�����>
				else if((num[i]>num[i+1])&&(num[i+1]<=num[i+2])) {
					buy+=num[i+1];
					count+=1;
				}//>����<
			}
			if(num[K-2]<num[K-1]) {
				sell=num[K-1]*count -buy;
				total+=sell;
			}
			price[t]=total;
		}
		for (int j = 0; j < T; j++) {
			System.out.println("#" + (j+1) + " " + price[j]);
		}
	}
}
