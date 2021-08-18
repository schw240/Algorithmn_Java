package SWEA.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_김한주_129ms {

	static class BC implements Comparable<BC> {
		int x;
		int y;
		int c;
		int p;
		
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return o.p - this.p; // 가장 큰 P를 찾기 위해 내림차순 정렬
		}

		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
		
		
	}
	
	static int M, A;
	static int ax, ay, bx, by;
	static int[] dr = {0, 0, 1, 0, -1}; // 제자리, 4방탐색
	static int[] dc = {0, -1, 0, 1, 0};
	static int[] personA, personB;
	static int[][] map = new int[11][11];
	static BC[] bc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) { 
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 총 이동시간 
			A = Integer.parseInt(st.nextToken()); // BC의 개수
			
			// 0부터 시작하므로 주의
			personA = new int[M + 1];
			personB = new int[M + 1];
			
			bc = new BC[A];
			
			// A 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < M + 1; ++i) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			
			// B 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < M + 1; ++i) {
				personB[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC 정보 입력
			for (int i = 0; i < A; ++i) {
				st = new StringTokenizer(br.readLine(), " ");				
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				bc[i] = new BC(x, y, c, p);
			} // ---------------------------------------- 여기까지 입력 완료
			
			
			// 시작 위치
			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;
			
			int answer = 0;
			
			// 초기위치 0초부터 충전할 수 있음
			for (int i = 0; i < M + 1; ++i) { 
				// 이동 person안에 담긴 이동정보대로 A이동
				ay += dc[personA[i]]; 
				ax += dr[personA[i]];
				
				// 이동 person안에 담긴 이동정보대로 B이동
				by += dc[personB[i]];
				bx += dr[personB[i]];
				
//				System.out.println("ax: " + ax + " ay: " + ay + " bx: " + bx + "  by: " + by);
				
				// 현재 위치에서 붙어있는 BC를 전부 찾아 P가 높은 순으로 정렬
				PriorityQueue<BC> aPQ = new PriorityQueue<>();
				PriorityQueue<BC> bPQ = new PriorityQueue<>();
				
				
				for (int j = 0; j < A; ++j) {
					
					int aDist = Math.abs(ax - bc[j].x) + Math.abs(ay - bc[j].y);
					int bDist = Math.abs(bx - bc[j].x) + Math.abs(by - bc[j].y);
					
					if (aDist <= bc[j].c) { // 충전범위 안에 A가 있다면
//						System.out.println(bc[j].toString() + " A안 넣는 값");
						aPQ.add(bc[j]); // 큐에 담아주기
					}
					
					if (bDist <= bc[j].c) { // 중전범위안에 B가 있다면
//						System.out.println(bc[j].toString() + " B안 넣는 값");
						bPQ.add(bc[j]);
					}
				}
				
				int sum = 0;
				
				// 큐에 값이 들어있다면 사용할 수 있는 충전량을 가지고 경우의 수를 다 구해주기. 
				if (!aPQ.isEmpty() && !bPQ.isEmpty()) { // 이게 둘다 비어있지 않은 경우에는 중복되는 지점이 있을 수 있음
					for (BC aBC : aPQ) {
						for (BC bBC : bPQ) {
//							System.out.println("aBC: " + aBC + " bBC: " + bBC);
							if (aBC.x == bBC.x && aBC.y == bBC.y) { // 같은 위치에있다면 
								if(sum < aBC.p) {  
									sum = aBC.p; 
								}
								continue;
								
							}
							if(sum < aBC.p + bBC.p) { // 아니라면
								sum = aBC.p + bBC.p;
							}
						}
					}
				} else if (!aPQ.isEmpty() && bPQ.isEmpty()) {
					// B가 비어있다면 A만 접근이 가능하므로 이때의 최대 P는 A의 우선순위큐 맨 앞의 값이 된다.
					sum = aPQ.poll().p;
				} else if (aPQ.isEmpty() && !bPQ.isEmpty()) {
					// A가 비어있다면 B만 접근이 가능하므로 이때의 최대 P는 B의 우선순위큐 맨 앞의 값이 된다.
					sum = bPQ.poll().p;
				}
				
				answer += sum;
			} // 탐색 완료
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		} // end of tc
		
		System.out.println(sb);
	}
} // end of class
