package 프로그래머스.고득점kit.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	
	public static int solution(int[][] routes) {
		// 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한번은 만나도록 카메라를 설치
		// 고속도로를 이동하는 차량의 경로 routes 가 주어질 때 모든 차량이 한번은 단속용 카메라를 만나려면 최소 몇대를 설치해야하는지?
		
		int answer = 0;
		// 나가는 지점순으로 정렬
		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
			
		});
//		System.out.println(Arrays.deepToString(routes)); // 확인
		
		// 최대한 겹치는 위치 찾기
		// 일단 첫번쨰 카메라는 배치해야함
		// -13, -5에 배치하면 최소 or -13, -3에 설치하면 최소
		int camera = Integer.MIN_VALUE;
		for(int[] route : routes) {
			// 현재 카메라 위치가 기작지점보다 작으면
			if(camera < route[0]) {
				// 종료위치에 설치
//				System.out.println(route[1]);
				camera = route[1];
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		
		int ans = solution(routes);
		System.out.println(ans);
		
	} // end of main
} // end of class
