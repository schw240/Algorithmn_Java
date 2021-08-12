package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_김한주_136ms {
	
	static int N;
	static boolean[] visited;
	static int answer;
	static int[][] foods;
	
	public static void main(String[] args) throws Exception {
		
		// N개의 재료
		// 재료의 신맛S(곱) , 쓴맛 B(합)
		// 재료를 적절히 섞어 신맛과 쓴맛의 차이를 작게 만들려고 하고 재료는 적어도 하나 사용해야한다.
		// 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램 작성하기
		
		//입력 N
		// 신맛S, 쓴맛B 공백으로 구분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		foods = new int[N][2]; // 재료 2개
		// 1000,000,000 보다 작은 양의 정수.. 문제 잘 읽자
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			foods[i][0] = Integer.parseInt(st.nextToken());
			foods[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		makeFoods(0);
		System.out.println(answer);
		// 출력: 신맛과 쓴맛의 차이가 가장 작은 요리의 차이 출력
		
	} // end of main
	
	private static void makeFoods(int idx) {
		
		if (idx == foods.length) { // 재료의 길이만큼 반복 
			int checkCnt = 0;
			int S = 1;
			int B = 0;
			// answer 계속 갱신해주어야함
			
			for(int i = 0; i < visited.length; i++) { 
				if(visited[i] == true) { // 방문한 곳이면
					S *= foods[i][0];
					B += foods[i][1];
					checkCnt++;
				}
			}
			if(checkCnt == 0) { // 적어도 하나 사용해야 하므로 이 조건이 꼭 있어야함
				return;
			}
			
			if(answer > Math.abs(S-B)) { 
				answer = Math.abs(S-B);
			}
			
			return;
		}
		
		// 재료 선택했을 때
		visited[idx] = true;
		makeFoods(idx + 1);
		// 재료 선택 안했을 때
		visited[idx] = false;
		makeFoods(idx + 1);
		
	} // end of subset
	
} // end of class
