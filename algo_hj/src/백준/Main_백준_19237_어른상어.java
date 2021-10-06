package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_19237_어른상어 {

	static class Shark {
		int x, y, no;

		public Shark(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N, M, K, ans;
	static int sharkMap[][]; // 상어의 번호를 저장하는 2차원배열
	static int smellMap[][]; // 상어의 냄새를 적어주는 2차원배열 ( 0~K 까지 )
	static int sharkDir[]; // 현재 상어의 방향을 저장하는 1차원배열
	static int sharkPriorityDir[][][]; // 상어의 우선순위 방향을 저장

	// 상어의 위치,번호 저장 , 내림차순
	static PriorityQueue<Shark> sharkList = new PriorityQueue<>((o1, o2) -> (o2.no - o1.no));

	// 상어의 흔적 (좌표,번호) 저장
	static HashMap<String, Integer> smellList = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 상어 마리수
		K = Integer.parseInt(st.nextToken()); // 냄새 없어지데 걸리는 시간

		sharkMap = new int[N][N];
		smellMap = new int[N][N]; // 냄새용 맵
		sharkDir = new int[M + 1]; // 1번부터
		sharkPriorityDir = new int[M + 1][4][4]; // 각 상어당 4줄씩 우선순위가 들어옴
		// 우선순위는 첫번째 줄은 상어가 위를 향할때 우선순위, 두번쨰는 아래, 세번쨰는 왼쪽, 네번째는 오른쪽을 향할때 우선순위

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sharkMap[i][j] = Integer.parseInt(st.nextToken());
				if (sharkMap[i][j] != 0) { // 상어가 들어있다는 의미
					sharkList.add(new Shark(i, j, sharkMap[i][j])); // 상어 pq삽입
					smellMap[i][j] = K; // 상어 위치에 상어 냄새 넣어두기
					// key value를 넣어줘야함 (좌표, 번호)
//					System.out.println(Integer.toString(i) + "," + Integer.toString(j) + sharkMap[i][j]);
					smellList.put(Integer.toString(i) + "," + Integer.toString(j), sharkMap[i][j]);
				}
			}
		}

		// 확인
//		smellList.forEach((key, value) -> {
//			System.out.println("{" + key + " , " + value + "}");
//		});

//		while(sharkList.size() > 0) {
//			System.out.println(sharkList.poll().no);
//		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) { // 상어 방향 우선순위 1부터 1234 상하좌우
			sharkDir[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 1; i <= M; i++) { // 각 상어마다
			for (int j = 0; j < 4; j++) { // 상하좌우
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) { // 방향우선순위
					sharkPriorityDir[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		} // 여기까지 입력완료

		ans = solution();

		System.out.println(ans);

	}

	private static int solution() {

		// 이동
		boolean flag = false;
		int time = 0;
		
		while (time < 1001) {
			
			
			int size = sharkList.size();
			if (size == 1) { // 상어 한마리만 남았다면 종료하기
				return time;
			}
			
			
			for (int i = 0; i < size; i++) {
				
				Shark shark = sharkList.poll();
				
				int x = shark.x;
				int y = shark.y;
				
				flag = false; // 아무냄새 없는 방향으로 갔는지 체크
				
				// 아무 냄새 없는 방향
				for (int d = 0; d < 4; d++) {
					// 현재 방향 정해서 X,Y좌표 바꾸기 // 상어 숫자 높은애들부터
					int nx = x + dx[sharkPriorityDir[shark.no][sharkDir[shark.no]][d]];
					int ny = y + dy[sharkPriorityDir[shark.no][sharkDir[shark.no]][d]];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue; // 범위 벗어나면
					}
					
					
					if (smellMap[nx][ny] != 0) { // 이미 다른 상어의 냄새가 있다면
						continue; 
					}

					// 갈 수 있으니까 sharkMap, shrakList바꿔주기
					sharkMap[x][y] = 0;
					sharkMap[nx][ny] = shark.no;
					sharkDir[shark.no] = sharkPriorityDir[shark.no][sharkDir[shark.no]][d]; // 상어방향 바꿔주기
					flag = true;
					break;
				}

				// 여기까지 왔다면 갈곳이 없으므로 내 냄새가 있는곳으로 이동
				if (!flag) {
					for (int d = 0; d < 4; d++) {
						// 각 상어 번호별 우선순위 방향대로 이동
						int nx = x + dx[sharkPriorityDir[shark.no][sharkDir[shark.no]][d]];
						int ny = y + dy[sharkPriorityDir[shark.no][sharkDir[shark.no]][d]];

						if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
							continue; // 범위 벗어나면
						}
						
						
						if (smellList.get(Integer.toString(nx) + "," + Integer.toString(ny)) != shark.no) {
							continue; // 지금 상어의 냄새가 아니라면
						}

						
						// 갈 수 있으니까 sharkMap, shrakList바꿔주기
						sharkMap[x][y] = 0;
						sharkMap[nx][ny] = shark.no;
						sharkDir[shark.no] = sharkPriorityDir[shark.no][sharkDir[shark.no]][d]; // 상어방향 바꿔주기
						break;
					}
				}

			}
			
			
			// 이동 다하고 겹친거 처리해주기 + 냄새 뿌리기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (smellMap[i][j] != 0) { // 냄새가 있다면 빼주기
						if (--smellMap[i][j] == 0) { // 만약 1 뺏을 때 0 이라면
							smellList.remove(Integer.toString(i) + "," + Integer.toString(j)); // 삭제
						}
					}

					if (sharkMap[i][j] != 0) { // 상어가 있다면 pq에 상어넣고 냄새 추가하기
						sharkList.add(new Shark(i, j, sharkMap[i][j]));
						smellList.put(Integer.toString(i) + "," + Integer.toString(j), sharkMap[i][j]);
						smellMap[i][j] = K;
					}
				}
			}
			time++;
		}
		
		// 1000초 초과하면 -1
		return -1;
	}


} // end of class
