package 인프런;

import java.util.*;
import java.io.*;

public class 암호 {
	
	public static String solution(int N, String str) {
		String ans = "";
		
		for(int i = 0; i < N; i++) {
			String tmp = str.substring(0,7).replace("#", "1").replace("*", "0");
			str = str.substring(7);
			
			int num = Integer.parseInt(tmp, 2);
			ans += (char)num;
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		System.out.println(solution(N, str));
		
	}

}
