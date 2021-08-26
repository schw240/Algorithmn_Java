package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1289_원재의메모리복구하기_D3 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			// 메모리의 원래값
			String str = br.readLine();
			char[] before = str.toCharArray();
			int ans = 0; // 고쳐야하는 최소값
			char temp = '0';
			
			// 초기화된 메모리에서 원래 메모리로 돌려놔야함
			// 모든 bit가 0에서 시작
			
			for(int i = 0; i < str.length(); i++) {
				
				if(before[i] != temp) {
					temp = before[i];
					ans++;
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		} // end of tc
		
		
	} // end of main
} // end of class
