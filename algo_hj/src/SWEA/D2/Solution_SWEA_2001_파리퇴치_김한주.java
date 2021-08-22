package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] nums = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(nums[i][j] + " ");
//				}
//				System.out.println();
//			} // 확인
			
			// M X M 크기의 파리채를 내리쳐 최대한 많은 파리 죽이고자할때 죽은 파리 개수 구하기
			int ans = 0;
			
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					int max = 0;
					for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							max += nums[i + k][j + l];
						}
					}
					ans = Math.max(max, ans);
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		} // end of tc
		
		
		
		
	} // end of main
} // end of class
