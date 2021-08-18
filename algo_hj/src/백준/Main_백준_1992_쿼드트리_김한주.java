package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_김한주 {
	
	private static int N;
	private static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void QuadTree(int x, int y, int size) {
		
		if(isPossible(x, y, size)) {
			// 압축이 가능한경우
			sb.append(map[x][y]);
			return;
		}
		
		int	size_new = size / 2; // 압축이 불가능한경우  절반으로 나누기
		sb.append('(');
		
		QuadTree(x, y, size_new); // 왼쪽 위
		QuadTree(x, y + size_new, size_new); // 오른쪽 위
		QuadTree(x + size_new, y, size_new); // 왼쪽 아래
		QuadTree(x + size_new, y + size_new, size_new); // 오른쪽 아래
		
		sb.append(')');
		
	} // end of QuadTree
	
	public static boolean isPossible(int x, int y, int size) {
		
		int num = map[x][y]; 
		
		// 반복문 돌면서 압축 가능한지 안한지 체크
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(num != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	} // end of isPossible
	
	public static void main(String[] args) throws Exception {
		
		
		// 0과 1로  검은점을 나타내는 2차원배열에서 한곳에 많이 몰려있으면 쿼드 트리에서는 이를 압축하여 간단히 표현
		// 모두 0으로만 되어있으면 압축 결과는 0이 되고 모두 1로만 되어있으면 1이 된다.
		// 만약 0과 1이 섞여있으면 전체를 한번에 나타내지 못하고 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래 4개로
		// 나누어서 압축하게 된다. 이 압축한 결과를 차례대로 괄호에 묶어서 표현
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 입력완료
		
		QuadTree(0, 0, N);
		System.out.println(sb);
		
	} // end of main
} // end of class
