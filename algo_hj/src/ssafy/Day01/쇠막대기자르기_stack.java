package ssafy.Day01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기_stack {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("쇠막대기자르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 1; i <= TC; i++) {
			int result = 0;
			char[] input = br.readLine().toCharArray();
			
			boolean flag = false;
			for (char c : input) {
				//System.out.print(c + " ");
				if (c == '(') {
					stack.push(c);
					flag = false;
				} else {
					// )
					stack.pop();
					
					if(!flag) {
						// 레이저 일때
						result += stack.size();
						flag = true;
						//System.out.print("cnt : "+result+" |");
					}
					else {
						// 쇠막대기 끝날때
						result += 1;
					}
				}
			}

			System.out.println("#" + i + " " + result);
		}
	}


}
