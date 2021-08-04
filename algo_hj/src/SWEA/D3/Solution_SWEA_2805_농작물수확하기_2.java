package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_2805_농작물수확하기_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] m = new int[N][N];
			int sum = 0; // 누적할 변수
			for(int i = 0; i < m.length; i++) {
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					
					if(N/2 <= i+j && i+j <= N/2*3 && 
							-N/2 <= i-j && i-j <= N/2) {
						
						sum += str.charAt(j) - '0';
					}
				}
			}

		
			
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
} // end of class
