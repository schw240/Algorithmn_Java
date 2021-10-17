package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2817_로또_김한주 {
	
	
	private static int[] lotto;
	private static int[] nums;
	static boolean[] isSelected;
	private static int K;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1~49까지의 번호 중 6개를 선택해야 한다.
		// 49개중에서 K개가 이미 선택되어있다고 할때
		
		// 수의 개수 K와 K개의 자연수가 주어짐
		String[] s = br.readLine().split(" ");
		K  = Integer.parseInt(s[0]);
		lotto = new int[6];
		nums = new int[K];
		isSelected = new boolean[K];
		
		int idx = 1;
		for(int i = 0; i  < K; i++) {
			nums[i] = Integer.parseInt(s[idx++]);
		} 
		
//		System.out.println(Arrays.toString(nums));
		
		// 여기서 이제 K 개의 수로 만들 수 있는 로또를 출력하기
		
		dfs(0, 0);
		
	} // end of main

	private static void dfs(int lev, int start) {
		// TODO Auto-generated method stub
		
		if(lev == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 이게 1부터 시작해서 50 까지 숫자 중 nums 안에 들어있는 값을 비교
		for(int i = start; i < K; i++) {
//			if(nums[i] != -1) { // -1이 아니라면 입력받은 숫자가 있다는 것을 의미
			lotto[lev] = nums[i]; // 현재 lev에다가 지금의 nums 값을 넣음
			dfs(lev + 1, i + 1); // 그리고 다음 lev로 넘어가고 i를 하나 증가시켜서 탐색
//			}
		}
		
		
	}
	
	
	
} // end of class
