package SWEA.D1;

import java.util.Scanner;

public class Solution2058 {
	public static void main(String[] args) {
		
		// 하나의 자연수를 입력받아 각 자릿수의 합을 계산하는 프로그램을 작성하라
		
		// 입력으로 자연수 N
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int res = 0;
		while(N > 0) {
			res += N % 10; // 일의자리 수 더함
			N /= 10; // 더한 일의 자리수 제거
		}
		System.out.println(res);
		
		
	} // end of main
} // end of class
