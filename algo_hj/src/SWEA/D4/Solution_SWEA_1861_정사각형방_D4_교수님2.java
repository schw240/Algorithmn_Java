package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 자료구조: 선형 자료구조 , 비선형 자료구조
 * 선형 자료구조: 양이 많은 데이터를 처리할 때 보통 사용(같은 타입만 집어넣음)[나 다음에 데이터의 위치가 명확한 자료구조] 1:1 관계, 순서를 알 수 있는
 * 
 * 비선형 자료구조: 1:N 관계, 그래프
 * 				개념 용어
 * 				저장
 * 				순회 : 모든 정점을 빠짐없이 한번씩 방문하는 것
 * 					이진트리 -
 * 						저장: 배열,
 * 						순회: 전위, 중위, 후위	
 *
 */
public class Solution_SWEA_1861_정사각형방_D4_교수님2 {


	private static int[][] A;
	private static int N;
	private static int[][] memo;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N][N];
			memo = new int[N][N];
			for(int i = 0; i < A.length; i++) { // N도 상관없지만 A는 지금 상수이기에 더 접근이 빠름
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				for(int j = 0; j < A.length; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료
			
			
//			for(int i = 0; i < A.length; i++) {
//				System.out.println(Arrays.toString(A[i]));
//			} // 입력한것 확인
			
			
			int max = 0; // 최대 이동할 수 있는 방의 개수
			int num = Integer.MAX_VALUE; // 최대 이동할 떄의 방의 숫자
			for(int r = 0; r < A.length; r++) { // 행
				for(int c = 0; c < A.length; c++) { // 열 모든 칸에서 탐색 시작
					int val = go(r, c);// r, c에서 출발해서 최대 몇칸까지 갔다 올 수 있는지
					if(max < val || (max == val && num > A[r][c])) {
						max = val;
						num = A[r][c];
					}
					
				}
			}
			sb.append("#").append(testCase).append(" ") .append(num).append(" ").append(max).append("\n");
			
			
		} // end of for testCase
		
		System.out.print(sb);
	} // end of main
	
	private static int[] dr = {-1, 1, 0,0}; // 상하좌우
	private static int[] dc = {0,0, -1, 1};
	
	/** 현재 좌표에서 최대 갈수 있는 이동칸 수를 리턴 */
	private static int go(int r, int c) {
		if(memo[r][c] > 0) {// 이미 왔었는지 확인, 왔었으면 기록된 최대 이동 칸 수 리턴하고 끝내기
			return memo[r][c];
		
		}
		memo[r][c] = 1; // 이동칸수, 아무곳도 못가도 내칸 1개 경로 있으니까 1로 초기화
		int num = A[r][c];
		for(int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (0 <= nr && nr < N && 0<= nc && nc < N && A[nr][nc] == num + 1) { // 배열의 범위 내에 있는지 확인하고 인접한 칸이 내 방의 숫자보다 1 큰 경우 이동
				// 1크면 이동
				memo[r][c] += go(nr, nc); // 내칸 하나에 다음칸 갈수있는 칸 하나씩 누적
				break; // 외길이기 때문에 빠져나오기 1 큰값은 하나밖에 없음
			}
		}
		
//		return 0; // Todo 나중에 수정 
		return memo[r][c];
	}
} // end of class
