package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1244_스위치켜고끄기_김한주 {

	public static void main(String[] args) throws IOException {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine());// 스위치 개수
		int[] switches = new int[switchNum];
		StringTokenizer st = new StringTokenizer(br.readLine()); // 스위치의 상태
		for(int i = 0; i < switchNum; i++) {
			switches[i] = Integer.parseInt(st.nextToken()); // 스위치 입력
		}
		int num = Integer.parseInt(br.readLine());// 학생 수
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken()); // 학생의 성별 학생이 받은 수 (남자 1, 여자 2)
			
			
			if (sex == 1) { // 남학생이면 스위치 번호가 자기가 받은 수의 배수이면 스위치 상태 바꿈
				for(int j = 0; j < switchNum; j++) {
					if((j + 1)% number == 0) {
						// 배수이면 스위치 상태 변경
						if(switches[j] == 1) {
							switches[j] = 0;
						} else {
							switches[j] = 1;
						}
					}
				}
			} else { // 여학생은 자기가 받은 번호의 스위치의 좌우 대칭 확인하고 가장 많은 스위치를 포함하는 구간 모두 변경
				
				int LP = number - 1; // 받은 숫자를 기준으로 왼쪽 오른쪽
				int RP = number - 1;
				
				while(true) {
					// 대칭 부위 찾기
					LP--;
					RP++;
					if(RP>= switches.length || LP < 0 || switches[LP] != switches[RP]) { // 범위 벗어나거나 대칭이 아니라면
						LP++;
						RP--;
						break;
					}
				}
				
				for(int k = LP; k <= RP; k++) { // 대칭시작부분 LP 부터 RP까지 값 모두 바꿔주기
					if(switches[k] == 1) {
						switches[k] = 0;
					} else {
						switches[k] = 1;
					}
				}
				
			}
		}
		
		
		
		// 출력
		// 1번부터 한줄에 20개씩 출력 (21번쨰는 둘 째 줄 출력
		for(int i = 0; i < switchNum; i++) {
			System.out.print(switches[i] + " ");
			if((i + 1) % 20 == 0) { // 20개 넘어가면 줄바꿈
				System.out.println();
			}
		}
		
		
		
		
		
	} // end of main
} // end of class
