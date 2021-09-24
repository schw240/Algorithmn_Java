package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1094_막대기 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		// 64인 막대에서 길이가 X인 막대를 가지고싶다.
		// 막대를 자른다음 풀로 붙여 길이가 X인 막대로 만들려고할때
		
		// 1. 가지고 있는 모든 막대의 길이를 더한다. 합이 X보다 크다면
		// 1-1. 가지고있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
		// 1-2. 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반중 하나를 버린다.
		// 2. 남은 모든 막대를 붙여서 X를 만든다.
		
		// 몇개의 막대를 붙여서 X를 만들 수 있는지 구하라
		
		int ans = 0;
		
		// X에서 1의 개수 찾아서 더해주기
		// 1,2,4,8,16,32,64
		for(int i = 0; i < 7; i++) {
			if((X & (1 << i)) > 0) {
				ans += 1;
			}
		}
		
		
		
		System.out.println(ans);
		
		
		
	} // end of main
} // end of class
