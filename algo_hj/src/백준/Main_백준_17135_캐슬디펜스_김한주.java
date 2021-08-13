package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17135_캐슬디펜스_김한주 {

//	격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
	static int[][] map;
	static StringTokenizer st;
	static int ans;
	static int[][] temp;

	static int N, M, D;
	static int[] archer;

	public static void main(String[] args) throws Exception {

//		입력
//		첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행 크기
		M = Integer.parseInt(st.nextToken()); // 열 크기
		D = Integer.parseInt(st.nextToken()); // 궁수가 공격할 수 있는 거리

		archer = new int[M];
		for (int i = 0; i < M; i++) {
			archer[i] = i;
		}

		map = new int[N][M];
		temp = new int[N][M];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 확인
//		System.out.println(N + ", " + M + ", " + D);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		int[] archer_place = new int[3];
		combination(0, 0, archer_place);

//		출력
//		첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.

		System.out.println(ans);
	} // end of main
	
	// 1. 조합을 사용해서 궁수의 위치 조합, 각 조합에서의 제거 가능한 적의 수 구하기
	// 2. 각 조합마다 원래의 map에서 연산을 해야하므로 임시변수 temp를 만들고 매 조합이 완성되었을 때마다 map 복사
	// 3. 조합 combination 함수에서 각 조합이 완성될 때마다 다음을 수행

	// 3-1 map을 복사한 temp 준비
	// 3-2 제거 가능한 적의 수를 저장할 변수 cnt
	// 3-3 마지막 행 다음에 있는 궁수들을 앞으로 옮김
	// 3-4 제거할 적의 위치를 저장할 큐 준비

	// 4. turn이 N보다 작으면 반복
	// 4-1 완성된 하나의 조합temp의 각 궁수들마다 반복(k)
	// 4-1-1. 궁수의 행 위치는 N-turn, 열 위치는 temp[k] (turn이 증가하면 궁수들 행 위치도 한칸씩 전진)
	// 4-1-2 각 궁수가 공격할 적까지의 거리, 그 적의 위치를 저장할 변수 min, minX, minY 선언
	// 5. temp의 행과 각 행의 열 반복
	// 5-1 temp[i][j]가 1이면(적이면) (i,j)와 현재 궁수의 위치(N-turn, temp[k])의 거리 계산
	// 5-2 거리가 최대 공격거리 D 이하이면
	// 5-2-1 min 보다 작다면 min, minX, minY 모두 현재 적 정보로 갱신
	// 5-2-2 min과 같다면 minY 와 현재 적의 열 인덱스 값을 비교하여 더 작은 적으로 갱신(더 작은게 왼쪽)
	// 6. 5번이 끝나면 (모든 맵의 칸을 조사했다면)
	// 6-1. 구한 제거할 적의 위치 minX, minY가 -1이 아니라면 큐에 삽입(제거할 적이 없을 땐 -1일수도 있음 -> 스킵)
	// 7. 4-1이 끝나면 (한 조합의 모든 궁수들을 다 확인했다면)
	// 7-1. q가 빌때까지 계속 x,y좌표를 꺼내어 copyMap 의 해당 내용을 0으로 바꾸고 cnt값 1 증가
	// (여러 궁수가 하나의 적을 제거할 수 있으므로 중복된 x,y좌표값이 있을 수 있으나 상관 없음)
	// 7-2 turn 값 1 증가
	// 8. 5번이 끝나면(모든 턴이 끝나면)maxVal과 비교하여 더 큰값으로 갱신
	public static void combination(int cnt, int start, int[] archer_place) {

		if (cnt == 3) { // 3명 궁수 선택
			for (int i = 0; i < N; i++) {
				temp[i] = Arrays.copyOf(map[i], M); // 맵 복사
			}
			for (int i = 0; i < N; i++) { // 복사된 값 체크
				System.out.println(Arrays.toString(temp[i]) + "temp 체크");
			}

			int count = 0;
			int turn = 0;
			Queue<Integer> q = new LinkedList<>();

			while (turn < N) {
				// 하나의 턴
				for (int k = 0; k < 3; k++) {
					// 한턴마다 궁수 앞으로 땡기기
					int x = N - turn;
					int y = archer_place[k];

					int min = Integer.MAX_VALUE;
					int minX = -1;
					int minY = -1;
					/// 각 궁수마다 가장 가까운 적 찾기(거리가 가장 가까운 적이 1순위, 같으면 왼쪽
					for (int i = N - 1 - turn; i >= 0; i--) { // 행은 맨 아래(궁의 바로 앞)부터 탐색
						for (int j = 0; j < M; j++) {
							if (temp[i][j] == 1) { // 적 있다면
								int d = Math.abs(i - x) + Math.abs(j - y); // 거리 체크
								if (d <= D) { // 만약 적과 현재 궁수(temp[k]) 거리가 D 이하라면 공격 가능
									if (d < min) { // 거리가 min보다 작다면 갱신 -> 공격 우선순의를 체크
										min = d;
										minX = i;
										minY = j;
									} else if (d == min) { // 거리가 같을땐 더 왼쪽에 있는 적 위치로 갱신
										if (minY > j) {
											minX = i;
											minY = j;
										}
									}
								}
							} // if - copyMap[i][j] == 1
						} // for - j
					} // for - i

					// 구한 archer_place[k]가 죽일 적의 위치를 큐에 삽입 - 죽일 적이 없어서 초기값인 (-1,-1)이라면 제외
					if (minX != -1 && minY != -1) {
						q.offer(minX);
						q.offer(minY);
					}
				} // for - k(궁수 3명 탐색)

				while (!q.isEmpty()) {
					int x = q.poll();
					int y = q.poll();
					if (temp[x][y] == 1) {
						temp[x][y] = 0;
						count++;
					}
				}
				////// 하나의 턴 끝//////
				turn++;
			}

			if (ans < count) {
				ans = count;
			}
			return;
		} // if문 종료 체크

		for (int i = start; i < archer.length; i++) {
			archer_place[cnt] = archer[i]; // 현재 궁수선택
			combination(cnt + 1, i + 1, archer_place);
		} // start부터 반복

	} // end of combination

} // end of class
