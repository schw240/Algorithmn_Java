package zoff;

import java.util.Arrays;

public class CombinationTest1 {
	
	static int N = 3, R = 2; // 3개중 2개뽑는 조합
	static int[] input;
	static int[] numbers;
	
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
	
		
		comb(0, 0);
	}
	
	private static void comb(int cnt, int start) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// start 위치의 수부터 가능한 수 모두 고려
		for(int i = start; i < N; i++) { // i는 인덱스
			
			numbers[cnt] = input[i];
			
			// 다음자리 조합 뽑으러 
			comb(cnt + 1, i + 1);
			
			
		}
	}
	
}
