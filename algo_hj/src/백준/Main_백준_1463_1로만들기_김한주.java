package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1463_1로만들기_김한주 {
	private static int[] dp;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int[N+1];
		dp[0] = dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			int one;
			int two = Integer.MAX_VALUE;
			int three = Integer.MAX_VALUE;
			
			if(i % 3 == 0) three = dp[i/3] + 1;
			if(i % 2 == 0) two = dp[i/2] + 1;
			
			one = dp[i-1] + 1;
			
			int res = Math.min(Math.min(two, three), one);
			
			dp[i] = res;
			
		}

		System.out.println(dp[N]);
		
	} // end of main
	
	
} // end of class
