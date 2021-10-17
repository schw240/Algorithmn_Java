package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_17609_회문 {
	
	static int T;
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); 
		
		// 회문인지 판별하여 회문이면 0, 유사 회문이면 1, 둘 모두 아니면 2 출력
		
		for(int i = 0; i < T; i++) {
			String s = br.readLine();
			
			ans = check(s); 
			
			System.out.println(ans);
		}
		
	} // end of main
	private static int check(String s) {

		ans = 0;
		
		int left = 0;
		int right = s.length() - 1;
		boolean flag1 = true;
		boolean flag2 = true;
		
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) { // 둘이 같으면 아직까진 회문
				left++;
				right--;
			} else {
				// 다르면 여기부턴 회문아님. 유사회문인지 검사
				ans++; // 일단 1증가
				
				int l2 = left; 
				int r2 = right;
				
				// 같지않은 문자 지워서 가능한지 체크해보기
				l2++; // 왼쪽 문자 한칸 띄고 체크
				while(l2 < r2) {
					if(s.charAt(l2) == s.charAt(r2)) {
						l2++;
						r2--;
					} else {
						flag1 = false;
						break;
					}
				} 
				
				l2 = left; 
				r2 = right;
				// 오른쪽 한칸 띄고 체크
				r2--;
				while(l2 < r2) {
					if(s.charAt(l2)==s.charAt(r2)) {
						l2++;
						r2--;
					} else {
						flag2 = false;
						break;
					}
				}
				
				if(flag1 == false && flag2 == false) {
					ans++; // 회문, 유사회문도 아니므로 다시 1증가
				}
				
				return ans;
				
				
			}
		}
		
		
		return ans;
	}
	
	
} // end of class
