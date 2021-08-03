package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1208_Flatten_D3_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for(int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr= new int[100];
			int sum = 0;
			
			for(int i = 0; i < 100; i++) {
				int x = Integer.parseInt(st.nextToken());
				arr[i] = x;
				sum += x;
				
			}
			
			int target = 1;
			if(sum % 100 == 0) {
				target = 0;
			}
			
			
			Arrays.sort(arr); // 배열의 오름차순 정렬
			
			for(int i = 0; i < n && arr[99] - arr[0] > target; i++) {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			
			
			sb.append("#").append(testCase).append(" ").append(arr[99] - arr[0]).append("\n");
		}
		System.out.print(sb);
	}
}
