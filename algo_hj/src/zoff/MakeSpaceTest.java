package zoff;

public class MakeSpaceTest {
	
	static int white, green;
	static int[][] spaces;
	
	
	public static void main(String[] args) {
		
		int n = 8;
		spaces = new int[][] {
			{1,1,0,0,0,0,1,1},
			{1,1,0,0,0,0,1,1},
			{0,0,0,0,1,1,0,0},
			{0,0,0,0,1,1,0,0},
			{1,0,0,0,1,1,1,1},
			{0,1,0,0,1,1,1,1},
			{0,0,1,1,1,1,1,1},
			{0,0,1,1,1,1,1,1}
		};
		
		cut(0,0,n);
		
		System.out.println(green);
		System.out.println(white);
	}
	
	
	private static void cut(int r, int c, int size) { // 행좌표, 열좌표, 크기
		
		int sum = 0;
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				sum += spaces[i][j];
			}
		}
		
		// 같은 색인지 체크
		if(sum == size * size) {
			// 같으면 초록색
			green++;
		} else if(sum == 0) {
			// 0이면 전부 하양
			white++;
		} else {
			// 색이 섞여있다는 의미이므로 재귀
			// 4분할 하여 각각의 사각형으로 처리
			int half = size / 2; 
			
			cut(r, c, half); // 1사분면(현재 r,c를 4각형의 1사분면 시작좌표로 잡음)
			cut(r, c + half, half); // 2사분면 시작점은 행은 그대로이고 열을 half만큼 이동한 위치
			cut(r + half, c, half);
			cut(r + half, c + half, half);
		}
		
		
	}
	
	
	
}
