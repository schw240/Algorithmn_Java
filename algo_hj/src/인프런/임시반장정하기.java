package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 임시반장정하기 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 학생 수를 나타내는 정수
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인
		
		int ans = 0; 
		// 임시 반장으로 정해진 학생의 번호 출력하기(임시 반장이 될 수 있는 학생이 여러명인 경우 가장 작은 번호 출력)
		int idx = 0;
		int num = 9999;
		
		for(int i = 1; i < N+1; i++) { // 학생
			int cnt = 0;
			idx = 0;
			
			for(int j = 1; j < N+1; j++) { // 반
				
				for(int k = 0; k < N; k++) {
					if(map[i][k] == map[k][j]) {
						// ik는 학생 고정 학년확인 kj는 학년고정 반 확인
						idx = i;
						cnt++;
					}
				}
				ans = Math.max(ans, cnt);
				num = Math.max(num, idx);
				
				
			}
		}
		
		System.out.println(num);
	} // end of main
} // end of class
