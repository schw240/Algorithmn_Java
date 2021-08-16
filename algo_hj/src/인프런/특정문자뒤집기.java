package 인프런;

import java.io.*;
import java.util.*;

public class 특정문자뒤집기 {
	// 영어 문자가 주어지면 영어 알파벳만 뒤집고, 특수문자는 그대로 있는 문자열 출력하기
	
	
	public static String Solution(String str) {
		
		String answer = "";

		int lp = 0, rp = str.length() -1;
		char[] c = str.toCharArray();
		while(lp < rp) {
			// 만약 왼쪽 포인터가 가르키는 값이 알파벳이 아니라면 lp 증가
			if(!Character.isAlphabetic(c[lp])) lp++;
			// 오른쪽 포인터가 가릌티는 값이 알파벳이 아니라면 rp 감소
			else if(!Character.isAlphabetic(c[rp])) rp--;
			else {
				// 둘다 알파벳이라면 스왑
				char tmp = c[lp];
				c[lp++] = c[rp];
				c[rp--] = tmp;
			}
				
		}
		answer = String.valueOf(c);
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(Solution(str));
	} // end of main
} // end of class
