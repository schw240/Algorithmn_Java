package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1208_Flatten_교수님 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 1차원 배열에 상자의 높이만 기록
		// 덤프작업 반복(덤프 회수 모두 소진시까지, 평탄화가 완료될 때 까지
		// 평탄화의 목표값, 합 % 100 == 0 ? 0 : 1
		
		// 입력 BufferedReader
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());  // 덤프의 횟수 1~1000
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] cnt = new int[101]; // 상자의 높이를 카운팅하자. 1<= 상자의 높이 <= 100
			int max = 1; // 최대 상자의 높이
			int min = 100; // 최소 상자의 높이
			int sum = 0; // 모든 상자의 개수 합
			
			for(int i = 0; i < 100; i++) {
				int x = Integer.parseInt(st.nextToken());
				cnt[x]++; // 높이 카운팅
				
				// 전체 합구하기, 최대값, 최소값 구하기
				if(max < x) max = x;
				if(min > x) min = x;
				sum += x; // 들어오는 박스 마다 누적 -> 전체합
			}
			
			int target = 1; // 평탄화의 목표치
			if(sum % 100 == 0) {
				target = 0;
			}
			
			// 덤프 : 최대값 -> 최소값 1개 이동: 최대값 --, 최소값++
			for(int i = 0; i < n && max - min > target; i++) { // 덤프 작업 반복(횟수 소진시 까지) 평탄화가 완료될 때 까지
				cnt[max]--; // 가장 높은 박스에서 박스를 하나 빼기
				cnt[max-1]++; // 가장 낮은 박스에서 박스를 하나 더하기
				cnt[min]--;
				cnt[min+1]++;
				if(cnt[max] == 0) max--;
				if(cnt[min] == 0) min++;
			}
//			System.out.println("#" + testCase + " " + (max-min));
			sb.append("#").append(testCase).append(" ").append(max-min).append("\n");
			
		} // end of testCase
		
		System.out.print(sb);
		
	} // end of main
} // end of class
