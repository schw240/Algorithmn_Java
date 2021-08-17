package 프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
	
	public static ArrayList<Integer> solution(int[] answers) {
		
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third = {3,3,1,1,2,2,4,4,5,5};
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == first[i%(first.length)]) {
				cnt1++;
			}
			if(answers[i] == second[i%(second.length)]) {
				cnt2++;
			}
			if(answers[i] == third[i%(third.length)]) {
				cnt3++;
			}
		}
		
		// 가장 높은 점수받은사람 출력
		int max = Math.max(Math.max(cnt1, cnt2), cnt3);
		
		ArrayList<Integer> list = new ArrayList<>();
		if(max == cnt1) list.add(1);
		if(max == cnt2) list.add(2);
		if(max == cnt3) list.add(3);
		
		return list;
		
	}
	
	public static void main(String[] args) {
		
//		int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		
		ArrayList<Integer> res = solution(answers);
		
		System.out.println(res.toString());
		
	}
}
