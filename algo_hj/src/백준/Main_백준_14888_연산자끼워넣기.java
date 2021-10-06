package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기 {
	
	static int N; // N개의 수
	static int[] nums;
	static int[] operators;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N개의 수
		// N개 수열
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 덧셈, 뺄셈, 곱셈, 나눗셈의 개수
		st = new StringTokenizer(br.readLine(), " ");
		operators = new int[4];
		for(int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(nums[0], 1);
		
		
//		System.out.println(Arrays.toString(nums));
//		System.out.println(Arrays.toString(operators));
		
		
		// 만들수 있는 식의 결과의 최대값
		System.out.println(max);
		// 만들수 있는 식의 결과의 최소값
		System.out.println(min);
		
	} // end of main
	
	private static void dfs(int num, int cnt) {
		if (cnt == N) {
			max = Math.max(max,  num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			// 연산자만큼
			if(operators[i] > 0) {
				operators[i]--;
				
				if(i == 0) {
					// 덧셈
					dfs(num + nums[cnt], cnt + 1);
				} else if(i == 1) {
					// 뺄셈
					dfs(num - nums[cnt], cnt + 1);
				} else if(i == 2) {
					// 곱셈
					dfs(num * nums[cnt], cnt + 1);
				} else if(i == 3) {
					// 나눗셈
					dfs(num / nums[cnt], cnt + 1);
				}
				
				operators[i]++;
			}
		}
		
	} // end of dfs
	
} // end of class
