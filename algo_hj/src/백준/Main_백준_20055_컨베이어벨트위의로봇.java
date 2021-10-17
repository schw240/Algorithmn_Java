package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_20055_컨베이어벨트위의로봇 {

	static int N;
    static int K;
    static int[] A;
    static boolean[] robot;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 길이가 N인 컨베이어 벨트
		// 길이가 2N인 벨트가 위아래로 감싸며 돌고있다.
		// 벨트는 길이 1 간격으로 2N개 칸으로 나눠져있으며 각 칸에는 아래 그림과 같이 1부터 2N까지의 번호가 매겨져있다.
		
		// 벨트가 한칸 회전하면 1번부터 2N-1번까지의 칸은 다음 번호의 칸이 있는 위치로 이동하고 2N번 위치는 1번 칸의 위치로 이동한다.
		// i번 칸의 내구도는 A[i], 1번칸은 올리는 위치, N번칸은 내리는 위치
		
		// 올리는 위치에만 올릴 수 있으며 내리는 위치에 도달하면 즉시 내린다. 그리고 로봇이 올리거나 어떤 칸으로 이동하면 내구도는 1 감소
		
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robot = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        
        // 종료될때 몇번째 단계가 진행중인지 구하고 1단계부터 시작
        
        int ans = solution(0);
        
        System.out.println(ans);
        
        
        
	} // end of main
	
	private static int solution(int cnt) {

		
		// 과정
		// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전
		// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
		// 2-1 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없어야하고 내구도가 1 이상이어야한다.
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		// 4. 내구도가 0인 칸의 개수가 k개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		
        while (isOK()) {
            int temp = A[A.length - 1]; // 1. 벨트 한 칸 회전
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {    // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false; 
            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    A[i]--;
                }
            }

            if (A[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robot[0] = true;
                A[0]--;
            }
            
            cnt++;
        }
		
		
		return cnt;
	}
	
	
	public static boolean isOK() {
        int cnt = 0;

        // 4. 0의 개수 체크
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
} // end of class
