package zoff;

import java.util.Arrays;

public class PermutationTest {
	
	static int N = 3, R = 3;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0); // 0부터 시작
	}
	
	
	
	public static void permutation(int cnt) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			// 가능한 수 모두 시도
			if(isSelected[i]) continue; // 사용중인 수면 다음
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt + 1);
			isSelected[i] = false;
		}
		
	}
	
}
