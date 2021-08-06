package SWEA.D2;

import java.util.Scanner;

public class Solution_SWEA_1940_가랏RC카_D2_김한주 {
	public static void main(String[] args) {
		
		
//		RC (Radio Control) 카의 이동거리를 계산하려고 한다.
//		입력으로 매 초마다 아래와 같은 command 가 정수로 주어진다.
//		0 : 현재 속도 유지.
//		1 : 가속
//		2 : 감속
//		위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
//		가속도의 단위는, m/s2 이며, 모두 양의 정수로 주어진다.
//		입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산하는 프로그램을 작성하라.
//		RC 카의 초기 속도는 0 m/s 이다.
		
//		[입력]
//		입력은 첫 줄에 총 테스트 케이스의 개수 T, 다음 줄부터 각 테스트 케이스가 주어진다.
//		테스트 케이스 첫 줄에는 Command 의 수 N이 주어지고, 둘째 줄부터, 매 줄마다 각각의 Command가 주어진다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int speed = 0;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int command = sc.nextInt();
				
				switch(command) {
				case 0: // 현속도 유지
					break;
					
				case 1: // 가속
					speed += sc.nextInt();
					break;
					
				case 2: // 감속
					speed -= sc.nextInt();
					break;
				}
				
				if (speed < 0) { // 예외처리 감속한 속도가 더 클 경우 속도는 0
					speed = 0;
				}
				sum += speed;
				
			}
			
			System.out.println("#" + tc + " " + sum);
		} // end of tc
		
//		[출력]
//		테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
//		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

		
	} // end of main
} // end of class
