package 인프런;

import java.util.*;
import java.io.*;

public class 회문문자열 {
	
	public static String solution(String str) {
		
		String answer = "NO";
//		str = str.toLowerCase(); 
		// 만약 문자열 전체를 소문자나 대문자로 바꾸고 싶다면
//		str = str.toLowerCase();
		
		String tmp = new StringBuilder(str).reverse().toString(); // stringbuilder 사용하기
		
		// equalsIgnoreCase 사용하면 대소문자 구분X
		if(str.equalsIgnoreCase(tmp)) answer = "YES";
		
//		for(int i = 0; i < str.length() / 2; i++) {
//			if(str.charAt(i) != str.charAt(str.length() -1 -i)) return "NO";
//			
//		}
		return answer;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
		
	} // end of main
} // end of class
