package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1158_요세푸스문제_김한주_616ms {



	public static void main(String[] args) throws IOException {
		
		
		// N명의 사람이 원을 이루며 앉아있고 양의 정수 K가 주어질때 K번째 사람을 순서대로 제거
		// 한사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정 반복
		// N명의 사람이 모두 제거될 때 까지 반복
		
		
		// N과 K 가 빈 칸을 사이에 두고 순서대로 주어짐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		Queue<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//N명의 사람 원으로 앉아있음 -> 연결리스트 , 큐
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(q.size() > 1) {
			// N명의 사람들이 모두 제거될 때 까지 계속
			// 순서대로 K번째 사람을 제거 
			// 1 2 3 4 5 6 7 -> 3 6 2 7 5 1 4 이거 숫자가 지워져도 인덱스가 지워지는것이 아님 해당 인덱스 포함해서 K만큼 건너 뛴 다음에 해당 숫자 삭제개념
			for(int i = 0; i < K-1; i++) {
				// K번째 이전의 원소
				q.offer(q.poll()); // K 이전까지의 원소 빼고 다시 더해주고나서 K번째 원소 추출
			}
			int num = q.poll();
			if (num > 0) { // null값 들어가는 경우
				sb.append(num).append(", ");
			} 
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
		
		
	} // end of main
} // end of class
