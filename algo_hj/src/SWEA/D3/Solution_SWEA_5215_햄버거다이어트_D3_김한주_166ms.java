package SWEA.D3;

import java.io.*;
import java.util.*;


public class Solution_SWEA_5215_햄버거다이어트_D3_김한주_166ms {
	static int ans, cnt, N, L;
	private static int[] scores;
	private static int[] kcals;
	
	public static void main(String[] args) throws Exception {
		
		// 정해진 칼로리를 넘지 않는 햄버거
		// 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거 조합하기
		// 같은 재료 여러번 사용 불가, 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정
		
		//입력
		// 첫줄  T
		// 재료의 수 N, 제한 칼로리 L
		// N개의 줄에 재료에 대한 민기의 맛에 대한 점수와 칼로리를 나타내는 Ti가 공백으로 주어짐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			scores = new int[N];
			kcals = new int[N];
			
			for(int i = 0; i < N; i++) {
				// N개만큼 재료에 대한 민기의 점수와 칼로리
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}
			
			
			// 확인
//			System.out.println("N: " + N + " L: " + L);
//			System.out.println("scores: " + Arrays.toString(scores));
//			System.out.println("kcals: " + Arrays.toString(kcals));
			
			// 정렬 그리디 방식으로는 정답이 안나옴
//			Arrays.sort(scores);
//			Arrays.sort(kcals);
//			
//			int ans = 0;
//			
//			for(int i = N-1; i >= 0; i--) {
//				if(L - kcals[i] >= 0) {
//					// 맛에 대한 점수가 가장 높은 햄버거 위주
//					System.out.println("점수?: " + scores[i] + " 칼로리? : " + kcals[i]);
//					L -= kcals[i];
//					// 칼로리 제한이 안넘으면 
//					ans += scores[i];
//				}
//			}
			
			ans = 0;
			subSet(0, 0, 0);
			
			// 출력 #T(테스트케이스 번호) 주어진 제한 칼로리 이하의 조합 중에서 가장 맛에 대한 점수가 높은 햄버거의 점수를 출력한다.
			System.out.println("#" + tc + " " + ans);
			
		} // end of tc
	} // end of main
	
	private static void subSet(int cnt, int score, int kcal) {
		if(kcal > L) {
			// 제한 칼로리를 초과했다면
			return; 
		}
		if (cnt == N) {
			// N번만큼 확인했다면
			ans = Math.max(ans, score);
			return;
		}
		
		subSet(cnt + 1, score + scores[cnt], kcal + kcals[cnt]); // 선택한 경우
		subSet(cnt + 1, score, kcal); // 선택하지 않은 경우 기존 상태 유지 후 다음 항목
		
	} // end of subset
	
} // end of class
