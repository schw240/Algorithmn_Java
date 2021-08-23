package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1759_암호만들기_김한주 {
	
	private static int L;
	private static int C;
	private static String[] password;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 서로 다른 L개의 알파벳 소문자
		C = Integer.parseInt(st.nextToken()); // 조교들이 암호로 사용했을 법한 문자 종류 C가지
		
		// 암호는 L개의 서로 다른 알파벳 소문자로 구성되며 최소 1개의 모음과 최소 2개의 자음으로 구성된다고 한다.
		
		password = new String[C];
		visited = new boolean[C];
		
		password = br.readLine().split(" ");
		
		// 사전식이므로 정렬?
		Arrays.sort(password);
		
//		System.out.println(Arrays.toString(password));
		
		solution(0, "");
		
	} // end of main
	
	public static void solution(int idx, String str) {
		if(str.length() == L) {
			// 길이가 L이라면
			if(isPossible(str)) {
				System.out.println(str);
			}
			return;
		}
		
		
		if(idx == C) { // idx가 맨끝까지 왔으면 종료
			return;
		}
		
		
		solution(idx + 1, str + password[idx]); // 자기 자신과 다음 문자 같이
		solution(idx + 1, str); // 자기 자신만
		
	} // end of solution
	
	public static boolean isPossible(String str) {
		int vowel = 0; // 모음
		int consonant = 0; // 자음
		for(int i = 0; i < str.length(); i++) {
			if(isVowel(str.charAt(i))) {
				vowel++;
			} else {
				consonant++;
			}
		}
		
		return vowel >= 1 && consonant >= 2;
	}
	
	public static boolean isVowel(char ch) {
		return ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u';
	}
	
	
} // end of class
