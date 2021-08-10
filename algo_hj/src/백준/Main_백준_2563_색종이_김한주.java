package 백준;

import java.io.*;
import java.util.*;

public class Main_백준_2563_색종이_김한주 {
	public static void main(String[] args) throws Exception {
		
//		가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
//		이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.


//		입력
//		첫째 줄에 색종이의 수가 주어진다. 
//		이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 
//		색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 
//		두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 
//		색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		
//		int[] left = new int[N];
//		int[] right = new int[N];
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			left[i] = Integer.parseInt(st.nextToken());
//			right[i] = Integer.parseInt(st.nextToken());
//		}
//		int res = N * 100;
//		for(int i = 0; i < N; i++) {
//			 for(int j = i + 1; j < N; j++) {
//				 if(Math.abs(left[i] - left[j]) < 10) { // 겹친다면
//					 int row = 10 - (Math.abs(left[i] - left[j])); // 더 오른쪽에 있는 좌표 - 10 - 더 왼쪽에 있는 좌표  => 10 - (더 오른쪽 좌표 - 더 왼쪽 좌표) 10 - (5 -3)
//					 int col = 10 - (Math.abs(right[i] - right[j])); // 10 - (7 - 2) = 5
//					 res -= row * col;
//				 }
//			 }
//		}

		int[][] arr = new int[100][100];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			for(int j = row; j < row + 10; j++) { // 해당 위치 1로 변경
				for(int k = col; k < col + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		
//		출력
//		첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
	} // end of main
} // end of class
