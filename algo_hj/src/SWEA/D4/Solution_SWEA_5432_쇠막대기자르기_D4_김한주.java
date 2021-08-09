package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_5432_쇠막대기자르기_D4_김한주 {
	public static void main(String[] args) throws Exception {
		
		// 쇠막대기를 레이저로 절단하려고 할 떄
		// 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
		// 레이저는 양 끝점과도 겹치지 않는다.
		
		// 쇠막대기의 배치는 괄호를 이용하여 왼쪽부터 순서대로 표현한다.
		// 1. 여는 괄호와 닫는 괄호의 인접한 쌍()으로 표현된다. 
		
		// 쇠막대기와 레이저의 배치를 나타내는 괄호표현이 주어졌을 때 쇠막대기 조각의 총 개수를 구하는 프로그램 작성하기
		
		// 입력
		// 첫번째 줄에 테스트케이스 T
		// 각 테스트 케이스의 첫번째 줄에는 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {

			String str = br.readLine();
			char[] arr = new char[str.length()];
			Stack<Character> stack = new Stack<>();
			int pipe = 0;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i);
			}
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '(') {
					stack.add(arr[i]); // 쇠막대기인경우
										
				
				} else if(arr[i] == ')' && arr[i-1] == '(') {
					stack.pop(); // )를 만나면 ()는 레이저
					pipe += stack.size(); // 위에 쌓인 파이프 개수
					
				} else if(arr[i] == ')' && arr[i-1] == ')') {
					stack.pop();
					pipe += 1;
				}
			}
			
			
			System.out.println("#" + tc + " " + pipe);
//			while(!stack.isEmpty()) {
//				System.out.print(stack.pop());
//			} // 확인
			
			
		} // end of tc
		
		
		
	} // end of main
} // end of class
