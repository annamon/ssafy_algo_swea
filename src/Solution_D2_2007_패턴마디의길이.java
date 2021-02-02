import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이 {
	static int T;
	static int result1;
	static int result2;
	public static void main(String[] args) {
		
		Scanner scann= new Scanner(System.in);
		T = scann.nextInt();
		for (int i = 1; i <= T; i++) {
			String word = scann.next();
			for(int j=10; j>0; j--) {
				String a = word.substring(0,j); //
				String b = word.substring(j,2*j);
				String c = word.substring(2*j, 3*j);
				if ((a.equals(b))&&(a.equals(c))) {
					result1 = j;
					break;
				}
			}
			for(int k=1; k<10; k++) {
				String a = word.substring(0,k);
				String b = word.substring(k,2*k);
				String c = word.substring(2*k, 3*k);
				if ((a.equals(b))&&(b.equals(c))) {
					result2 = k;
					break;
				}
			}
			if((result2==1)&&(result1!=1)) {
				System.out.println("#"+i+" "+result1);
			}
			else {
				int result = (result1 > result2) ? result2 : result1;
				System.out.println("#"+i+" "+result);
			}
		}
	}
}