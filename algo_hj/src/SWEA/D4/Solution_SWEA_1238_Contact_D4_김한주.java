package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_김한주 {

	private static int start;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		
		// 그래프문제, 인접연결리스트
		
		// 비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수 작성
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			
			// 입력 데이터로 from, to 의 순서로 데이터가 들어옴
			// 순서는 상관이 없으므로 동일한 비상연락망을 나타냄
			// 반복되어 들어올 수 있으나 한번 기록된 경우와 여러번 기록된 경우의 차이는 없다 -> 자료구조 순서가 없으므로
			N = Integer.parseInt(st.nextToken()); // 입력받는 데이터 길이
			start = Integer.parseInt(st.nextToken()); // 데이터의 시작점
			
			ArrayList<Integer> arr[] = new ArrayList[101];
			for(int i = 0; i < 101; i++) {
				arr[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N/2; i++) {
				// from, to 형식으로 받아서 넣어주기
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
//				System.out.println("from: " + from + " to: " + to);
				arr[from].add(to);
			}
			
			int ans = start;
			int cnt = 0;
			
			boolean[] visited = new boolean[101];
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {start, 0});
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				if(visited[now[0]]) continue;
				visited[now[0]] = true;
				
				if(now[1] > cnt) { // 깊이가 만약 현재 cnt보다 큰 경우
					ans = now[0];
					cnt = now[1];
				}
				else if(now[1] == cnt && now[0] > ans) ans = now[0];
				
			}
			
			System.out.println("#" + tc + " " + ans);
			
		} // end of tc
		
		
	} // end of main
} // end of class
