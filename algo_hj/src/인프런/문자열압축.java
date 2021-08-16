package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열압축 {
	
	public static String solution(String str) {
		String ans = "";
		int cnt = 1;
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				cnt++;
			} else {
				ans += str.charAt(i);
				// int형을 스트링으로 바꿔줄때는 String.valueOf()사용하기
				if(cnt>1) ans += String.valueOf(cnt);
				cnt = 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str += " ";
		System.out.println(solution(str));

	} // end of main
}
