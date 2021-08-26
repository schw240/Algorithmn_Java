package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 격자판최대합 {
	private static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인

		// 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력하기

		int ans = Integer.MIN_VALUE;
		int sum1, sum2;
		// 행 확인
		for (int i = 0; i < N; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < N; j++) {
				sum1 += map[i][j];
				sum2 += map[j][i];
			}
			ans = Math.max(ans, sum1);
			ans = Math.max(ans, sum2);
		}
		
		// 양 대각선
		sum1 = sum2 = 0;
		for(int i = 0; i < N; i++) {
			sum1 += map[i][i];
			sum2 += map[i][N-1-i];
		}

		
		ans = Math.max(ans, sum1);
		ans = Math.max(ans, sum2);
		
		
		System.out.println(ans);

	} // end of main
} // end of class
