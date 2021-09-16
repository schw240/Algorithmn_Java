package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 가랏RC카 {
	static int T,Ans,N;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("가랏RC카.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N=sc.nextInt();
			int v = 0, dist = 0;
			for (int n = 0; n < N; n++) {
				int com = sc.nextInt();
				if(com !=0) {
					int a = sc.nextInt();
					if(com==1) {
						v+=a;
					}else {
						v-=a;
						if(v<0) {
							v = 0;
						}
					}
				}
				dist += v;
			}
			
			System.out.printf("#%d %d\n", tc, dist);
		}
	}

}
