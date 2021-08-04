package 프로그래머스.고득점kit.해시;

import java.util.*;

public class 전화번호목록 {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		HashMap<String, Integer> map = new HashMap<>(); // 해쉬맵 생성

		for (int i = 0; i < phone_book.length; i++) { // 해쉬멥에 모든 번호 추가
			map.put(phone_book[i], i);
		}

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j < phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
					return answer;
				}
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		
		boolean answer = true;
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
		answer = solution(phone_book);
		System.out.println(answer);
	}
}
