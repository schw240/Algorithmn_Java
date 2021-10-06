package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1515_구슬찾기 {
	public static void main(String[] args) throws Exception {


		// 무게가 모두 다른 N개의 구슬 1 ~ N번까지
		// 이 구슬 중 무게가 전체의 중간인 (무게 순서로 (N+1) / 2 번째
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken()); // 구슬 개수
		int M = Integer.parseInt(st.nextToken()); // M개의 쌍
		
		int[][] arr = new int[N + 1][N + 1];
		
		
		// 반의 값을 구함
		int half = (N + 1) / 2;
		
		
		// 양팔저울이 주어지고 한쌍의 구슬을 골라서 양팔 저울의 양쪽에 하나씩 올려보면 어느쪽이 무거운가를 알 수 있다.
		// 이렇게 M 개의 쌍을 골라서 각각 양팔저울에 올려서 어느 것이 무거운 가를 모두 알아냈다.
		// 이 결과를 이용하여 무게가 중간이 될 가능성이 없는 구슬 제외시키기
		
		// M개의 쌍에 대한 결과를 보고 무게가 중간인 구슬이 될 수 없는 구슬의 개수를 구하기
		int ans = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 앞번호의 구슬이 뒤 번호의 구슬보다 무겁다.
			// a는 b보다 큼
			arr[a][b] = 1; 
			arr[b][a] = -1;  
		}
		
		
		for (int i = 1; i <= N; i++) {// 거쳐가는 구슬
			for (int j = 1; j <= N; j++) {// 출발 구슬
				for (int k = 1; k <= N; k++) {// 도착 구슬
					// 구슬의 연결관계가 있을때
					// 출발 구슬-> 거쳐가는 구슬 , 거쳐가는 구슬-> 출발 구슬
					// 이런식으로 위치가 정렬되어 출발구슬이 도착구슬과 직접적인 연결이 아니어도
					// 위치가 지정되는 조건이 하나 더 성립됨
					if (arr[k][i] != 0 && arr[j][i] == arr[i][k])
						arr[j][k] = arr[j][i];
				}
			}
		}
		int[] big = new int[N + 1];
		int[] small = new int[N + 1];
		
		// 뒤에 오는 조건, 앞에 오는 조건의 개수를 각각 세어 저장
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (arr[i][j] == 1)
					big[i]++;

				if (arr[i][j] == -1)
					small[i]++;

			}
		}
		
		
		// 조건이 총구슬의 반이 넘으면 답의 개수를 늘려준다
		for (int i = 1; i <= N; i++) {
			if (big[i] >= half)
				ans++;
			if (small[i] >= half)
				ans++;
		}
		
		
		System.out.println(ans);

	} // end of main
} // end of class
