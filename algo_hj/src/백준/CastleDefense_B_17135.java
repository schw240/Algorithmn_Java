package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	private int x;
	private int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Pair() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
}

public class CastleDefense_B_17135 {
	static int N, M, D, minD, minX, minY;
	static int kill, maxKill = 0;
	static int[][] map; // 격자판
	static int[][] tempMap; // 임시 복제 격자판
	static boolean[][] enemy;
	static Queue<Pair> Axy = new LinkedList<>(); // 궁수 위치 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		tempMap = new int[N][M];
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (str.charAt(2 * j) - '0');
				tempMap[i][j] = map[i][j];
			}
		}
		
		System.out.println("입력후 확인" + Arrays.deepToString(map));
		System.out.println("입력후 확인" + Arrays.deepToString(tempMap));
		
		// 뒤쪽부터 3만큼 1채우기
		int cnt = 0;
		while (++cnt <= 3)
			map[N][M - cnt] = 1;
		do {
			// 순열 사용
			archerPlace();
			attack(map[N], map);
			initMap();
			if (kill > maxKill) { // 최대 처치 수 저장
				maxKill = kill;
			}
//            System.out.println(Arrays.toString(map[N]));
			while (Axy.size() != 0) {
				System.out.println(Axy.poll());
			}
		} while (np(map[N]));
//        System.out.println(Arrays.deepToString(map));
		bw.write(maxKill);
		bw.write(kill);
		bw.flush();
		bw.close();
		br.close();
	}

	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {

		int tmp = numbers.length;

		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = tmp - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = tmp - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1위치값과 j위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기(i)부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
		int k = tmp - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static void attack(int[] archer, int[][] map) { // 적들이 제외될때까지 처치 수 계산
		kill = 0; // 새로운 조합으로 계산 시 처치수 초기화
		for (int i = 0; i < N; i++) { // 적을 탐색하고 처치하는 로직
			enemy = new boolean[N][M];
			while (Axy.size() != 0) {
				Pair location = Axy.poll();
				minX = 0;
				minY = 0;
				for (int p = 0; p < M; p++) {
					for (int q = 0; q < N; q++) {
						int tempD = distance(location, q, p);
//						System.out.print("attack " + map[p][q] + " ");
						if (map[q][p] == 1 && tempD <= D) {
							if (minD > tempD) {
								minD = distance(location, q, p);
								minX = q;
								minY = p;
							}
						}
					}
//					System.out.println();
				}
				enemy[minX][minY] = true;
				if (minX == 0 && minY == 0 && map[0][0] == 0) { // x,y값이 초기화값일땐 해당 좌표에 적이 없다면 false로 바꾼다.
					enemy[0][0] = false;
				}
			}
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (enemy[x][y]) {
						map[x][y] = 0;
						kill++;
					}
				}
			}
			if (i == N - 1) { // 이미 적들은 다음에 전부 제외되므로 아래 for문을 시행하지 않고 빠져나옴
				break;
			}
			for (int m = N; m > 1; m--) { // 적들이 움직임
				map[m - 1] = map[m - 2];
			}
			for (int z = 0; z < M; z++) { // 적들이 움직이면 가장 윗줄은 0으로 초기화
				map[0][z] = 0;
			}
			System.out.println("attack 안 map 변화"+ Arrays.deepToString(map));
		}
	}

	private static void archerPlace() { // 궁수의 x,y 좌표 저장
		for (int i = 0; i < M; i++) {
			if (map[N][i] == 1) {
				Pair location = new Pair(N, i);
				Axy.add(location);
			}
		}
	}

	private static int distance(Pair p, int x, int y) {
		return Math.abs(p.getX() - x) + Math.abs(p.getY() - y);
	}

	private static void initMap() {
		System.out.println("*" + Arrays.deepToString(map));
		System.out.println("%%%%%%%%%%%%" + Arrays.deepToString(tempMap));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = tempMap[i][j];
				System.out.println("부분요소값" + map[i][j] + " " + tempMap[i][j]);
			}
			System.out.println("map 초기화 확인 : " + Arrays.toString(map[i]));
		}
		
		System.out.println("@@@@@");
		System.out.println(Arrays.deepToString(tempMap));
		System.out.println("초기화한 맵" + Arrays.deepToString(map));
		for(int i = 0; i < N; i++) {
			System.out.println("map 초기화 확인22222 : " + Arrays.toString(map[i]));
		}
		System.out.println("@@@@@");
	}
}