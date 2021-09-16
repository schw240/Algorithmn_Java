package ssafy.Day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 저수지물의총깊이 {
	static int T;
	static int N;
	static int[] day;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("백만장자프로젝트.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			day = new int[N];
			for (int i = 0; i < N; i++) {
				day[i] = sc.nextInt();
			}
			//System.out.println(Arrays.toString(day));
			int max = day[N - 1];
			long sum = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (day[i] < max) {
					sum += max - day[i];
				} else {
					max = day[i];
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}

}
