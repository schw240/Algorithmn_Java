package 인프런;

import java.io.*;
import java.util.*;

public class 문자찾기 {
	
	public static int solution(String str, char c) {
		int cnt = 0;
//		str = str.toLowerCase();
//		c = Character.toLowerCase(c);
//		for(int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == c)   {
//				cnt++;
//			}
//		}
		
		str = str.toLowerCase();
		c = Character.toLowerCase(c);
		
		for(char x : str.toCharArray()) {
			if (x == c) cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char c = br.readLine().charAt(0);
		
		int ans = solution(str, c);
		System.out.println(ans);
		
	} // end of main
} // end of class
