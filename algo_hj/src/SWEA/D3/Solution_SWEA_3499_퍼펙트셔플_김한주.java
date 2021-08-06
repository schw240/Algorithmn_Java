package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_김한주 {
	
	public static void main(String[] args) throws Exception {

			
//		[입력]
//		첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//		각 테스트 케이스의 첫 번째 줄에는 자연수 N(1 ≤ N ≤ 1,000)이 주어진다.
//		두 번째 줄에는 덱에 카드가 놓인 순서대로 N개의 카드 이름이 공백으로 구분되어 주어진다.
//		카드의 이름은 알파벳 대문자와 ‘-’만으로 이루어져 있으며, 길이는 80이하이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if(N % 2 == 0) {
				for(int i = 0; i < N/2; i++) {
					q1.add(st.nextToken());
				}
				for(int i = N/2; i < N; i++) {
					q2.add(st.nextToken());
				}
			} else {
//				System.out.println("여기로옴");
				for(int i = 0; i <= N/2; i++) { // 5    0 1 2
					q1.add(st.nextToken());
				}
				for(int i = N/2 + 1; i < N; i++) { // 2 3 4
					q2.add(st.nextToken());
				}
			}
			
			sb.append("#").append(tc);
			
			for(int i =0; i < N; i++) {
				if(i % 2 ==0) {
//					System.out.println(q1.peek() + " q1");
					sb.append(" ").append(q1.poll());
				} else {
//					System.out.println(q2.peek() + " q2");
					sb.append(" ").append(q2.poll());
				}
			}
			
			sb.append("\n");
			
		} // end of for testCase
		System.out.println(sb);
	
//			카드를 퍼펙트 셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것을 의미
//			N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성하라.
			
			
		
//		[출력]
//		각 테스트 케이스마다 주어진 덱을 퍼펙트 셔플한 결과를 한 줄에 카드 이름을 공백으로 구분하여 출력한다.

		
	} // end of main
} // end of class
