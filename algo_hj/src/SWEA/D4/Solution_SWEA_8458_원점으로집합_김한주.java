package SWEA.D4;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_8458_원점으로집합_김한주 {
	
	
	static int T, N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			
			// N개의 격자점. 
			// 이 점들을 몇번 움직여 모든 점을 원점으로 이동시키고 싶다.
			int[] dist = new int [N];
			int cnt = 0;
			
			
			for(int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				dist[i] =  Math.abs(x) + Math.abs(y);
			}
			
			boolean flag = true;
			
			for(int i = 1; i < N; i++) {
				if(dist[i-1] % 2 != dist[i] % 2) { // 홀수든 짝수든 둘의 값이 같아야지 이동가능
					flag = false;
				}
			}
			
			Arrays.sort(dist);
			
			// 가장 먼거리 확인
			if(flag) {
				int max = dist[N-1];
				int sum = 0;
				int tmp = 0;
				
				while(max > sum || (max - sum) % 2 != 0) {
					cnt++;
					sum += ++tmp;
				}
			} else {
				cnt = -1;
			}
			
			
			
			// 모든 점을 원점으로 이동시킬 수 없으면 -1 출력
			System.out.println("#" + tc + " " + cnt);
			
		} // end of tc
		
		
	} // end of main
	
	
} // end of class



