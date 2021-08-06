package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_김한주 {
	public static void main(String[] args) throws Exception {
		
		// 8개의 숫자 입력받아
		// 첫번째 숫자를 1 감소한 뒤 맨 뒤로 보낸다
		// 다음 첫번째 수는 2 감소한 뒤로 맨 뒤, 그 다음 첫번째 수는 3감소한 뒤 뒤로,...
		// 이 작업을 한사이클
		// 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지, 프로그램 종료후 최종 암호가 됨
		
		
		// 입력
		// 첫줄에는 테스트케이스 번호, 그 다음줄에 8개의 데이터
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 1; i++) {
//			int T = Integer.parseInt(br.readLine());
			int T = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
//			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 8; j++) {
				int number = sc.nextInt();
				queue.offer(number);
			}
			
			
			int cnt = 1; // cnt이용해서 한 사이클마다 몇씩 빼줄건지 결정
			
			while(true) {
				
				int num = queue.poll();
				if(num - cnt <= 0) {// 문제 조건에서 말한 숫자가 작아질때 0보다 작아지는 경우
					queue.offer(0); // 0으로 유지(앞에서 뺀거 뒤로 넣어줌)
					break;
				}
				queue.offer(num - cnt); // 위의 0 되는 조건 아닌경우 cnt만큼 빼고 뒤에 추가
				if(cnt == 5) { // cnt가 5면 한사이클
					cnt = 0;
				} else {
					cnt += 1;
				}
			} // end of while
			sb.append("#").append(T).append(" ");
			
			for(int j = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
			
			
		}
		
		//출력
		// #부호와 함께 테스트케이스의 번호 출력 후 공백 문자 후 테스트케이스의 답 도출
		System.out.print(sb);
		
		
		
		
	} // end of main
} // end of class
