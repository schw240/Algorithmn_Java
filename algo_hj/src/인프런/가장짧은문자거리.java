package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장짧은문자거리 {
	
	public static void solution(String str, char c) {
		
		int distance = 1000;
		int[] p = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				distance = 0;
				p[i] = distance;
			} else {
				distance++;
				p[i] = distance;
			}
		}
		
		// 확인
//		for(int i = 0; i < p.length; i++) {
//			System.out.print(p[i] + " ");
//		}
		
		distance = 1000;
		// 오른쪽부터 비교하면서 최소값 비교해서 넣어주기
		for(int i = str.length()-1; i >= 0; i--) {
			if(str.charAt(i) == c) {
				distance = 0;
			} else {
				distance++;
				p[i] = Math.min(p[i], distance);
			}
		}
	
		// 정답
		for(int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		String str = st.nextToken();
		char c = st.nextToken().charAt(0);
		solution(str, c);
		
	} // end of main
}
