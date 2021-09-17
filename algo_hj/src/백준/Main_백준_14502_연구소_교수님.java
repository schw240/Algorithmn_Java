package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


// 조합으로 3개의 벽의 위치를 선정해야함
// 0의 위치에다가


public class Main_백준_14502_연구소_교수님 {
	
	private static int[] t = new int[3];// 조합의 좌표 저장할 인덱스
	private static boolean[][] visited;
	private static int N;
	private static int M;
	private static int[][] mapOrigin;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 복사본
		mapOrigin = new int[N][M]; // 원본배열
		ArrayList<int[]> al0 = new ArrayList<>();
		ArrayList<int[]> al2 = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0, index = 0; j < M; j++, index += 2) {
				mapOrigin[i][j] = s.charAt(index); // 0빈칸, 1 벽, 2 바이러스
				if(mapOrigin[i][j] == '0') {
					al0.add(new int[] {i, j});
				}
				if(mapOrigin[i][j] == '2') {
					al2.add(new int[] {i, j});
				}
			}
		}
		
		// 벽을 놓을 위치 3개 조합으로 선택
		int maxCnt = 0; // 안전영역의 최대값
		visited = new boolean[N][M];
		comb(al0.size(), 3);
		
		System.out.println(maxCnt);
		
	} // end of main
	
	// 빈칸중에 3개의 좌표를 선택하는 조합 메서드
	private static void comb(int n, int r) {
		
		if(r == 0) {
			// 종료파트
			
			// 3군대 벽의 위치를 t배열에 인덱스로 저장
			// 맵을 복사

			int[][] map = new int[N][];
			for(int i = 0; i < N; i++) {
//				map[i] =  mapOrigin[i].clone(); // 이렇게 복사하면 객체를 생성함 -> 느림
//				map[i] =  Arrays.copyOf(mapOrigin[i], mapOrigin[i].length); // 한땀한땀 복사 
				// 객체를 생성, 내부적으로 System.arraycopy를 호출
				System.arraycopy(mapOrigin[i], 0, map[i], 0, mapOrigin[i].length);
				
			}
			
			
			
			// 벽의 위치 추가
			// 바이러스 퍼뜨리기 탐색 dfs
			dfs(1,1);
			
			// cnt카운팅
			// maxCnt 업데이트
			
			
		} else if(n < r) {
			// 종료파트 2
		} else {
			// 유도파트
			t[r-1] = n-1;
			comb(n-1, r-1);
			comb(n-1, r);
		}
		
	}
	
	private static void dfs(int i, int j) {
		
	}
	
} // end of class
