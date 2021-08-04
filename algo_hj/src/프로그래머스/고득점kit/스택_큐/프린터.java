package 프로그래머스.고득점kit.스택_큐;

import java.util.*;

public class 프린터 {

	public int solution(int[] priorities, int location) {
		int answer = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순으로 큐 작성
		for (int i : priorities) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {

				if (priorities[i] == queue.peek()) { // 큐 안에 있는것과 문서가 같으면
					if (location == i) { // 요청문서와 인덱스 비교후 맞으면 반환
						return answer;
					}
					answer++; // 아니면 answer 증가
					queue.poll(); // 해당 원소 추출
				}
			}
		}
		return answer;
	}
}
