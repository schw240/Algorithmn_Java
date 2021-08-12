package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16926_배열돌리기1_김한주 {
	
	private static int[] dr = {0, 1, 0, -1}; // 우상좌하
	private static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열 가로
		int M = Integer.parseInt(st.nextToken()); // 배열 세로
		int T = Integer.parseInt(st.nextToken()); // 반복 횟수
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌아가는 라인 수
		int cnt = Math.min(N, M) / 2; 
		
		
		for(int i = 0; i < T; i++) { // 회전 수 만큼 반복
			for(int j = 0; j < cnt; j++) { // 돌아가는 라인수 만큼 반복
			
				
				int temp = arr[j][j];
				
				for(int k = j+1; k < M-j; k++) {
					arr[j][k-1] = arr[j][k];
//					System.out.println("i,j,k : " + i + ", " + j + ", " + k);
//					System.out.println();
//					System.out.print(arr[j][k-1] + " ");
				}
//				System.out.println();
				for(int k = j+1; k < N-j; k++) {
					arr[k-1][M-1-j] = arr[k][M-1-j];
//					System.out.println("i,j,k : " + i + ", " + j + ", " + k);
//					System.out.println();
//					System.out.print(arr[k-1][M-1-j] + " ");
				}
//				System.out.println();
				for(int k = M-2-j; k>=j; k--) {
					arr[N-1-j][k+1] = arr[N-1-j][k];
//					System.out.println("i,j,k : " + i + ", " + j + ", " + k);
//					System.out.println();
//					System.out.print(arr[N-1-j][k+1] + " ");
				}
//				System.out.println();
				for(int k = N-2-j; k >= j; k--) {
					arr[k+1][j] = arr[k][j];
//					System.out.println("i,j,k : " + i + ", " + j + ", " + k);
//					System.out.println();
//					System.out.print(arr[k+1][j] + " ");
				}
//				System.out.println();
//				
//				System.out.println("i,j, temp : " + i + ", " + j + ", " + temp);
//				System.out.println();
				arr[j+1][j] = temp;
				
			}
			
		} // end of 회전
		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	} // end of main
} // end of class
