package 프로그래머스.고득점kit.동적계획법;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
//	static int answer = -1;// 전역변수로 설정
//
//	public static void dfs(int N, int number, int cnt, int sum) {
//		if (cnt > 8) {// 8번안에 끝내야한다
//			answer = -1;
//			return;
//		}
//		if (sum == number) {
//			if (answer == -1 || cnt < answer) {// 처음이거나 기존answer보다 더 최솟값을 발견했다면
//				answer = cnt;
//				return;
//			}
//		}
//		int NN = 0;
//		for (int i = 0; i < 8 - cnt; i++) {// 8번안에 끝내야하므로
//			NN = 10 * NN + N;// 숫자 N으로 만들 수 있는 수
//			dfs(N, number, cnt + i + 1, sum + NN);
//			dfs(N, number, cnt + i + 1, sum - NN);
//			dfs(N, number, cnt + i + 1, sum * NN);
//			dfs(N, number, cnt + i + 1, sum / NN);
//		}
//	} // end of dfs
//
//	public static int solution(int N, int number) {
//
//		dfs(N, number, 0, 0);
//		return answer;
//
//	}
	
	public static int solution(int N, int number) {
	       int answer = -1;
	        Set<Integer>[] setArr = new Set[9];
	        int t = N;
	        for(int i = 1; i < 9; i++) {
	            setArr[i] = new HashSet<>();
	            setArr[i].add(t);
	            t = t * 10 + N;
	        }
	        for(int i = 1; i < 9; i++) {
	            for(int j = 1; j < i; j++) {
	                for(Integer a : setArr[j]) {
	                    for(Integer b : setArr[i - j]) {
	                        setArr[i].add(a + b);
	                        setArr[i].add(a - b);
	                        setArr[i].add(b - a);
	                        setArr[i].add(a * b);
	                        if(b != 0) {
	                            setArr[i].add(a / b);
	                        }
	                        if(a != 0) {
	                            setArr[i].add(b / a);
	                        }
	                    }
	                }
	            }
	        }
	        for(int i = 1; i < 9; i++) {
	            if(setArr[i].contains(number)) {
	                answer = i;
	                break;
	            }
	        }
	        return answer;
	}

	public static void main(String[] args) {
		int N = 5;
//		int N = 2;
		int number = 12;
//		int number = 11;

		System.out.println(solution(N, number));
	} // end of main
} // end of class
