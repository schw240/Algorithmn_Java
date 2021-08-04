package 프로그래머스.고득점kit.스택_큐;

import java.util.*;

class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = progresses.length - 1; i >= 0; i--) {
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0)); // 몫 + 나누어
																											// 떨어지면 0 아님
																											// 1
		}

		List<Integer> s = new ArrayList<Integer>();

		while (!stack.isEmpty()) {
			int cnt = 1;

			int top = stack.pop();

			while (!stack.isEmpty() && stack.peek() <= top) { // 처음 해야하는 작업을 추출하고 다음으로 오는 값 stack.peek이 해당 값보다 작다면 이미
																// 작업이 끝났다는 의미
				cnt++;
				stack.pop();
			}

			s.add(cnt); // 카운팅한 값 저장
		}

		int[] answer = new int[s.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.get(i);
		}

		return answer;
	}
}
