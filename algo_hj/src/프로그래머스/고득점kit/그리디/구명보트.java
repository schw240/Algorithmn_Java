package 프로그래머스.고득점kit.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구명보트 {

	public static int solution(int[] people, int limit) {
		int answer = 0;

		// 구명보트는 작아서 한번에 최대 2명밖에 탈수 없고 무게제한도 있음
		// 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최소값 return

		Arrays.sort(people);
//		System.out.println(Arrays.toString(people));

		int idx = 0;
		for (int i = people.length - 1; i >= idx; i--) {
//			System.out.println(people[i]);

			if (people[i] + people[idx] > limit) { // 가장 큰값과 가장 작은값 더해서 비교 만약 limit보다 크면 가장 뒤에사람 보내주기
				answer++;
//				idx++;

			} else { // limit보다 작다면
				answer++; // 둘이 태울수 있으므로 answer1증가
				idx++;

			}
		}

		return answer;
	}

	public static void main(String[] args) {

		int[] people = { 70, 50, 80, 50 };
//		int[] people = {70,80,50};
		int limit = 100;
		int ans = solution(people, limit);
		System.out.println(ans);

	} // end of main
} // end of class
