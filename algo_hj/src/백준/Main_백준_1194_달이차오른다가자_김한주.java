//package 백준;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_백준_1194_달이차오른다가자_김한주 {
//	
//	
//	static int N, M; // 미로의 세로크기 N , 가로크기 M
//	static char[][] map;
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//    static boolean[][][] visited;
//    
//    static Node ms;
//	
//	public static void main(String[] args) throws Exception {
//		
//		// 빈곳 : 언제나 이동 가능    '.'으로 표시
//		// 벽: 이동 불가능		  '#'으로 표시
//		// 열쇠 언제나 이동가능 처음 들어가면 열쇠를 잡음 a -> f
//		// 대응하는 열쇠가 있을 때만 이동 가능 A -> F
//		// 민식이의 현재 위치 빈곳이고민식이가 현재 서있는 곳  '0'
//		// 출구: 달이 차오르기 때문에 민식이가 가야하는곳. 이곳에 도착해야 미로 탈출 '1'
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		map = new char[N][M];
//		visited = new boolean[N][M][1<<7]; // 열쇠가 a~f까지임. 문도 A~F까지. 
//		
//		
//		for(int i = 0; i < N; i++) {
//			String s = br.readLine();
//			for(int j = 0; j < s.length(); j++) {
//				map[i][j] = s.charAt(j);
//				
//				if(map[i][j] == '0') {
//					ms = new Node(i,j,0,0); // (x,y,count, key)
//				}
//			}
//		} // 입력 완료
//		
////		System.out.println(N + " " + M);
////		for(int i = 0 ; i < N; i++) {
////			System.out.println(Arrays.toString(map[i]));
////		} // 확인
//		
//		bfs(ms.x, ms.y);
//		
//		
//		
//		
//	} // end of main
//	
//    private static void bfs(int x, int y) {
//		// TODO Auto-generated method stub
//    	Queue<Node> q = new LinkedList<>();
//    	
//    	q.add(new Node(x, y, 0,0));
//    	visited[x][y][0] = true;
//    	
//    	while(q.size() > 0) {
//    		Node cur = q.poll();
//    		int cnt = cur.count;
//    		int key = cur.key;
//    		
//    		if(map[cur.x][cur.y] == '1') { // 도착했다면
//    			System.out.println(cur.count);
//    			return;
//    		}
//    		
//    		for(int i = 0; i < 4; i++) {
//    			int nr = cur.x + dr[i];
//    			int nc = cur.y + dc[i];
//    			
//    			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 범위 벗어난 경우
//    			
//    			if(map[nr][nc] == '#' || visited[nr][nc][key]) continue; // 벽이거나 아니면 방문한경우
//    			
//    			if(map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' < 6) { // a,b,c,d,e,f 6개
//    				// 열쇠일때 이거 어떻게하냐 이검ㄴ이람ㄴㅇㄹ
//    				int key2 = (1 << (map[nr][nc] - 'a')) | key; // or연산을 하면 비트 추가 즉 key와 연산해서 비트를 추가하는것
//    				
//    			} else if() {
//    				// 문일때
//    				
//    				
//    				// 일치하는 열쇠가 있다면
//    				if() {
//    					
//    				}
//    			} else {
//    				visited[nr][nc][key] = true;
//    				q.add(new Node(nr, nc, cnt + 1, key));
//    			}
//    				
//    		}
//    	}
//    	
//    	
//    	System.out.println(-1); // 정답안나오면 -1
//		
//	}
//
//	static class Node {
//        int x;
//        int y;
//        int count;
//        int key;
//
//        public Node(int x, int y, int count, int key) {
//            this.x = x;
//            this.y = y;
//            this.count = count;
//            this.key = key;
//        }
//    } // end of Node
//	
//} // end of class
