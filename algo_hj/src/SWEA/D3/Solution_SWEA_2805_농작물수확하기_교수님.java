package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_2805_농작물수확하기_교수님 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] m = new int[N][N];
			
			for(int i = 0; i < m.length; i++) {
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					m[i][j] = str.charAt(j) - '0'; // char를 숫자로 변환
				}
			}

//			for(int i = 0; i < m.length; i++) {
//				System.out.println(Arrays.toString(m[i]));
//			}
			
			int start = N/2; // 범위의 시작 위치
			int end = N/2; // 범위의 끝 위치
			int diff = 1; //증감할 값
			int sum = 0; //누적합
		
			
			for(int r = 0; r < m.length; r++) { //행
				for(int c = start; c <= end; c++) { // 열
					sum += m[r][c];
				}
				
				if(start == 0) { // 만약 start가 최대로 커졌으면 diff 방향 바꿔주기
					diff = -1;
				}
				
				start -= diff;    // 맨 처음에 start 와 end의 index가 같아서 같은값 하나만 더하고
				end += diff; 		// 그 다음 start는 -1 감소, end는 +1 증가해서 2개씩 더 더해주기
				
			}
			
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
} // end of class
