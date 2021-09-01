package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14465_소가길을건너간이유5_김한주 {
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 횡단보도N개, 각 횡단보도에 신호등 설치됨, 연속한 K개의 신호등이 존재하도록 신호등 수리
		
		// N, K, B
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N+1];
		boolean[] isBroken = new boolean[N+1];
		// 고장난 신호등 B개
		for(int i = 0; i < B; i++) {
			int num = Integer.parseInt(br.readLine()); // 고장난 신호등 번호
			isBroken[num] = true;
		}
		
		int cnt = 0;
		for(int i = 1; i < K + 1; i++) { // 연속한 K개 신호등 수리
			if(isBroken[i]) cnt++; // 망가진 개수 카운트
		}
		
		// 연속한 K 개의 신호등이 존재하도록 함
		
		sum[K] = cnt;
		int res = Integer.MAX_VALUE;
		
		for(int i = K + 1; i <= N; i++) { // 모든 K길이 구간에 대해 가장 적게 고장난 신호등 개수 구하기
			int tmp = sum[i-1];
			// 이번 횡단보도가 망가졌다면
			if(isBroken[i]) tmp++;
			// K번째 전에 망가진 횡단보도가 있었다면
			if(isBroken[i-K]) tmp--;
			
			sum[i] = tmp;
			res = Math.min(res,  tmp);
		}

		System.out.println(res);
		// 1 2 3 4 5 6 7 8 9 10
		// x x     x       x  x
		//           3 2 1 2  3
	} // end of main
} // end of class
