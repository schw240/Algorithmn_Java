package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13300_방배정_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 참가하는 학생수 N, 한방에 배정할 수 있는 최대 인원수 K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[7][2]; // 학년, 남녀 구분
		for(int i = 0; i < N; i++) {
			// 성별S 0여자 1남자, 학년 Y 1 ~ 6
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken()); // 성별
			int grade = Integer.parseInt(st.nextToken()); // 학년
			if(sex == 0) map[grade][0]++; //여성이면 학년[0] ++
			else map[grade][1]++; //남성이면 학년[1]++
			
		}
		int ans = 0;
		// 남자는 남자끼리 여자는 여자끼리 배정
		// 같은 학년의 학생만 배정 한명 배정도 가능
		for(int i = 1; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) continue; // i학년 학생이 없으면 통과
				ans += map[i][j] / K; // 방 수 더해주기
				if(map[i][j] % K != 0) ans++; // 나누어 떨어지지않으면 하나 추가
				
			}
		}
		
		System.out.println(ans);
		
		
		// 최소방 수 출력
		
	}
}
