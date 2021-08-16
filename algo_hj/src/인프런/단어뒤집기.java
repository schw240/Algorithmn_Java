package 인프런;

import java.io.*;
import java.util.*;
public class 단어뒤집기 {
	
	public static ArrayList<String> Solution(String[] strs) {
		 
//		for(int i = 0; i < strs.length; i++) {
//			String temp = strs[i];
//			String temp2 = "";
//			for(int j = temp.length()-1; j >=0; j--) {
//				temp2 += temp.charAt(j);
//			}
//			System.out.println(temp2);
//		}
		
		ArrayList<String> answer = new ArrayList<>();
//		
//		for(String x : strs) {
//			String tmp = new StringBuilder(x).reverse().toString();
//			answer.add(tmp);
//		}
		
		for(String x : strs) {
			char[] s = x.toCharArray();
			int lt = 0 , rt = x.length() - 1;
			while(lt < rt) {
				char tmp = s[lt];
				s[lt++] = s[rt];
				s[rt--] = tmp;
			}
			String tmp = String.valueOf(s); // char 배열을 String으로 바꿔줌
			answer.add(tmp);
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] strs = new String[N];
		for(int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		ArrayList<String> list = Solution(strs);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	} // end of main
} // end of class
