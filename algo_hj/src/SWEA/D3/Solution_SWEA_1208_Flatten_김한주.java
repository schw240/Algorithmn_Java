package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1208_Flatten_김한주 {
	public static void main(String[] args) throws IOException {
		
		
//		높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
//		평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
//		평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 
//		제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.
		
		
		
//		[제약조건]
//		주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 
//		그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

//		[입력]
//		총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int Dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 받고 정렬
			Arrays.sort(arr);
			
			for(int i = 0; i < Dump; i++) {
				arr[0]++; // 가장 작은값 1증가
				arr[arr.length-1]--; // 가장 큰값 1감소
				Arrays.sort(arr);
			}
			
	//		[출력]
	//		#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.
			System.out.printf("#%d %d\n", tc, arr[arr.length - 1] - arr[0]);	
			
		}

		
		
	} // end of main
} // end of class
