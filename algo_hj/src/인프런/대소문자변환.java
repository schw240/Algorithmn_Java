package 인프런;

import java.io.*;
import java.util.*;

public class 대소문자변환 {
	
	public static String Solution(String str) {
		
		String answer = "";
		
		// toCharArray함수는 문자열을 캐릭터 배열로 바꿔주는 메서드
//		for(char x : str.toCharArray()) {
//			// 아래처럼 Character 클래스로 접근하면 안에 사용할 수 있는 메서드가 나옴
//			// Integer.parseInt와 같은느낌
//			// CHaracter안에 isLowerCase같은 소문자인지 묻는 메소드가 있으므로 사용하기
//			if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//			else answer += Character.toLowerCase(x);
//		}

		
		// 아스키 방식을 사용하기
		// 아스키 번호로 대문자는 65 ~ 90 까지
		// 소문자는 97 ~ 122
		// 대문자와 소문자의 차이는 32
		for(char x : str.toCharArray()) {
			if( x >= 97 && x <= 122) answer += (char)(x-32); // 소문자에서 32를 빼주면 대문자로 변환됨
			else if(x >= 65 && x <= 90) answer += (char)(x+32);
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		System.out.println(Solution(str));
		
	} // end of main
} // end of class
