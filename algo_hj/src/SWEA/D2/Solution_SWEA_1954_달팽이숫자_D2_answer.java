package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1954_달팽이숫자_D2_answer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] m = new int[N][N];
			int r= 0;
			int c= 0;
			int size = N-1; // 이동할 크기
			int num = 1; // 저장할 숫자
			
			while(size > 0) { // 한바뀌 우하좌상
				for(int i = 0; i < size; i++) { // 우
					m[r][c] = num++;
					c++; // 오룬쪽으로 가면서 num 입력
				}
				
				for(int i = 0; i < size; i++) { // 하
					m[r][c] = num++;
					r++;
				}
				for(int i = 0; i < size; i++) { // 우
					m[r][c] = num++;
					c--; // 오룬쪽으로 가면서 num 입력
				}
				
				for(int i = 0; i < size; i++) { // 하
					m[r][c] = num++;
					r--;
				}
				
				size -= 2; // 이동할 크기 수정
				r++; c++;
				
				
//				break;
			}
			
			
			
		
			
			// 홀수일때 가장 가운대가 안들어감
			if(N % 2 != 0) { // N이 홀수이면
				m[r][c] = num; // 한가운대 값 넣기
			}
			
			
//			System.out.println(r + " , " + c); // 확인
//			for(int i = 0; i < m.length; i++) {
//				System.out.println(Arrays.toString(m[i]));
//			}
			
			
			sb.append("#").append(tc).append("\n");
			
			for(int i = 0; i < m.length; i++) {
				for(int j = 0; j < m[i].length; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			
		} // end of testCase
		
		
		System.out.println(sb);
		
		
	} // end of main
} // end of class
