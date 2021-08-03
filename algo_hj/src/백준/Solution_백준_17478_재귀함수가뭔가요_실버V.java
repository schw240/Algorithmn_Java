package 백준;

import java.util.Scanner;

public class Solution_백준_17478_재귀함수가뭔가요_실버V {
//	static String underbar = "";
	public static void main(String[] args) {
		
//		입력
//		교수님이 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 재귀횟수
		
//		출력
//		출력 예시를 보고 재귀 횟수에 따른 챗봇의 응답을 출력한다.
		
//		어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다. // 맨 처음 1번만 출력
//		"재귀함수가 뭔가요?" // 얘도 반복됨
		
//		"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//		마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//		그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어." // 여기까지가 반복되는 부분
//		____"재귀함수가 뭔가요?"
//		____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//		____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//		____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
//		________"재귀함수가 뭔가요?"
//		________"재귀함수는 자기 자신을 호출하는 함수라네" 
//		________라고 답변하였지. // 반복
//		____라고 답변하였지.
//		라고 답변하였지. // 얘도 반복
		
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
//		recursive(N);
		recur(N, "");
		
		
		
	} // end of main
	
	/** N: 현재 뎁스, tab: 들여쓰기할 문자열 */
	// 강사님 코드
	private static void recur(int N, String tab) {
		if (N == 0) { // 종료파트
			System.out.println(tab + "\"재귀함수가 뭔가요?\"");
			System.out.println(tab + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(tab + "라고 답변하였지.");
			return;
		} else { // 재귀파트
			System.out.println(tab + "\"재귀함수가 뭔가요?\"");
			System.out.println(tab + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(tab + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(tab + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			recur(N-1, tab + "____"); // 재귀
			System.out.println(tab + "라고 답변하였지.");
			
		}
	}
	

//	private static void recursive(int N) {
//		
//		String new_bar = underbar;
//		
//		if (N == 0) { // 기저조건 종료파트 basis
//			System.out.println(new_bar + "\"재귀함수가 뭔가요?\"");
//			System.out.println(new_bar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
//			System.out.println(new_bar + "라고 답변하였지.");
//			return;
//			
//		} else { // 재귀파트 inductive
//			System.out.println(new_bar + "\"재귀함수가 뭔가요?\"");
//			System.out.println(new_bar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
//			System.out.println(new_bar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
//			System.out.println(new_bar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
//		}
//
//		underbar += "____";
//		
//		recursive(N-1);
//		
//		
//		System.out.println(new_bar + "라고 답변하였지.");
//	}
	
} // end of class
