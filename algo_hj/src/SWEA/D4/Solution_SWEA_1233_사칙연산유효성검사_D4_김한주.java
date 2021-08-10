package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_김한주 {
	public static void main(String[] args) throws Exception {
		
		// 사칙연산으로 구성되어있는 식을 이진트리로 표현
		// 임의의 정점에 연산자가 있으면 해당 연산자의 왼쪽 서브트리의 결과와 오른쪽 서브트리의 결과를 사용해서 해당 연산자를 적용한다.
		
//		[입력]
//		각 테스트 케이스의 첫 줄에는 각 케이스의 트리가 갖는 정점의 총 수 N(1≤N≤200)이 주어진다.
//		그 다음 N줄에 걸쳐 각각의 정점 정보가 주어진다.
//		해당 정점에 대한 정보는 해당 정점의 알파벳, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점번호가 차례대로 주어진다.
//		정점 번호는 1부터 N까지의 정수로 구분된다. 입력에서 정점 번호를 매기는 규칙은 위와 같으며, 루트 정점의 번호는 반드시 1이다.
//		입력에서 이웃한 숫자 또는 연산자, 자식 정점의 번호는 모두 공백으로 구분된다.
//		위의 예시에서, 숫자 8이 4번 정점에 해당하면 “4 8”으로 주어지고, 연산자 ‘/’가 2번 정점에 해당하면 두 자식이 각각 숫자 ‘8’인 4번 정점과 숫자 ‘2’인 5번 정점이므로 “2 / 4 5”로 주어진다.
//		총 10개의 테스트 케이스가 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			// 10개의 테스트 케이스
			
			int N = Integer.parseInt(br.readLine()); // 각 케이스의 트리가 갖는 정점의 총 수 N
			
			int res = 1;
			// 연산자와 양의 정수로만 구성된 임의의 이진트리가 주어질 때 이 식의 유효성을 검사하는 프로그램을 작성해라
			// 유효성이란 계산이 가능하면 1, 불가능하면 0 출력
			
			for(int i = 0; i < N; i++) {
				// 알파벳, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점번호
				// 정점의 번호는 1부터 N까지 정수로 구분
				String s = br.readLine();
				String[] arr = s.split(" "); // 공백으로 잘라서 배열에 넣음
//				int num = 0;
//				int num1 = 0;
//				int num2 = 0;
//				String operator = "";
//				try {
//					num = Integer.parseInt(st.nextToken());
//					operator = st.nextToken();
//					num1 = Integer.parseInt(st.nextToken());
//					num2 = Integer.parseInt(st.nextToken());
//				} catch (Exception e) {
//					// 위에서 값 받을때 오류생긴 경우
//					res = 0;
//					sb.append("#").append(tc).append(" ").append(res).append("\n");
//					break;
//				} 
				// 정상적으로 받아왔을 때 조건 체크
//				if(operator == "+" || operator == "-" || operator == "*" || operator == "/") {
//					res = 1;
//				} else {
//					res = 0;
//				} 
				
				if(arr.length == 4) { // 부모는 연산
					if (arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) {
						continue;
					} else {
						res = 0;
					}
				} else {
					if (arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) {
						res = 0;
					}
				}
				
				
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		} // end of tc
		System.out.println(sb);
		
		
//		[출력]
//		#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 정답을 출력한다.
		
		
	} // end of main
} // end of class
