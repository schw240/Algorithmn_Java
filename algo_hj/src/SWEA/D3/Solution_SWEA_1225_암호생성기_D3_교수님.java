package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_교수님 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		for(int testCase = 1; testCase<= 10; testCase++) {
			int TC = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
//			Queue<Integer> q = new LinkedList<>();
//			for(int i = 0; i < 8; i++) {
//				q.offer(Integer.parseInt(st.nextToken()));
//			}
			
			int[] arr = new int[8];
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(min > arr[i]) {
					min = arr[i];
				}
			}
			
			int v = (min-1) / 15 * 15; // 8개 숫자에 뺄 값
			for(int i = 0; i < arr.length; i++) {
				arr[i] -= v;
			}

			
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i < arr.length; i++) {
				q.offer(arr[i]);
			}
			
ex:			while(true) {
				for(int i = 1; i <= 5; i++) {
					int num = q.poll();
					num -= i; // 꺼낸 값에서 1~5만큼 뺄셈
					if(num <= 0) {
						num = 0;
						q.offer(num);
						break ex; // 이렇게 라벨을 주면 라벨로 이동하게 됨
					}
					q.offer(num);
				}
			}
			sb.append("#").append(testCase);
			
			while(!q.isEmpty()) { // 큐의 숫자를 하나씩 꺼내서 출력문자열로 만들기
				sb.append(" ").append(q.poll());
				
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
		
	} // end of main
} // end of class
