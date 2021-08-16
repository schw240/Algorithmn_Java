package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자만추출 {
	
	public static int solution(String str) {
//		String answer = "";
//		
//		char[] c = str.toCharArray();
//		for(int i = 0; i < c.length; i++) {
//			if(Character.isDigit(c[i])) answer += c[i];
//		}
//		int ans = Integer.parseInt(answer);
		
		// 아스키코드로 48부터 57사이에 있다면 숫자라는 의미
		// 문자 0 은 48, 문자 9는 57
		int ans = 0; 
		for(char x : str.toCharArray()) {
			if(x >= 48 && x <= 57) ans = ans * 10 + (x-48);
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
	}
}
