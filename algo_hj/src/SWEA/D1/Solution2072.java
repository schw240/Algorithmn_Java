package SWEA.D1;


import java.util.Scanner;

/**
 * SWEA 에 제출 시 클래스명은 Solution
 * 백준, 정올에 제출 시 클래스명은 Main
 */

// public은 파일명과 동일한 클래스 네임을 가진 곳에만 1번 붙일 수 있음 main 제외
public class Solution2072 {
	public static void main(String[] args) {
//		3개 테스트케이스
//		10개 입력받아 홀수 더한 값을 출력
//		0이상 10000 이하의 정수 -> byte, short, int, long => 데이터 타입, 메모리 제한
		
//		위에는 입출력, 제한조건을 정리하고 그 다음 자료구조나 알고리즘 계획
//		어떻게 시작해야할 지 모르면 완전탐색으로 시작
//		그 다음부터 최적화
		
//		이 문제는 테스트케이스가 3개니깐
//		테스트 케이스만큼 반복문으로 묶음
//		테스트케이스를 입력받기 => Scanner, BufferedReader(입력 데이터가 3개 이상이면 더 빠름 입력이 많아질 수록 BufferedReader 사용하기)
//		반복문 (테스트케이스만큼) => for, while
//			반복문(10개입력)
//				홀수이면, 합 누적
		
//		if(가독성이 좋음), switch(알고리즘 측면에선 빠름 3번 이상 비교시)(정수 or 문자열 비교할 때)
//		for(횟수 or 범위가 미리 정해져있을 경우), while()
		
		Scanner sc = new Scanner(System.in); // 키보드로부터 사용자 입력을 받기 위한 객체를 준비
		int TC = sc.nextInt();
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			int sum = 0; // 누적할 변수
			for(int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				if (num % 2 != 0) { // 홀수 이면
					sum += num; // 합을 누적
				}
			}
			System.out.println("#" + (testCase) + " " + sum);
			sum = 0;
		} // end of for testCase
	} // end of main
} // end of Solution
