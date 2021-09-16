package ssafy.Day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 방배정 {
	static int N,K;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("방배정.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[][] room = new int[7][2];
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int level = sc.nextInt();
			room[level][gender]++;
		}
		int cnt = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 1; j++) {
				if(room[i][j]<=K && room[i][j]!=0) {
					cnt++;
				}else {
					//3  2  = 2
					//3 / 2 = 1
					//3 % 2 = 1
					cnt = cnt + room[i][j]/K;
					if(room[i][j]%K!=0) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
