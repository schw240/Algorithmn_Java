package zoff;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TestString {
	public static void main(String[] args) {
		
		String str1 = "abcdefghij"; // 상수풀에 메모리 확보 (권장되는 방법 빠르다)
		String str2 = "abcdefghij"; // 상수풀에 메모리 확보 (권장되는 방법 빠르다)
		System.out.println(str1 == str2); // true 주소도 같음
		System.out.println(str1.equals(str2)); // true 내용물 동일
		
		String str3 = new String("abcdefghij"); // new 키워드를 사용했기 떄문에 무조건 heap 영역에 생성됨
		String str4 = new String("abcdefghij"); // new 키워드를 사용했기 떄문에 무조건 heap 영역에 생성됨
		System.out.println(str3 == str4); // false 주소는 다름
		System.out.println(str3.equals(str4)); // true 값은 같음
		
		System.out.println(3 + 4 + "Hi" + 3 + 4);
		
		String str = "aBcdefGhiJ";
		
		System.out.println("2번째 index의 char 글자 얻어오기: " + str.charAt(2));
		System.out.println("문자열 이어붙이기 : " + str.concat("xyz")); // 덧셈연산과 동일한 결과
		System.out.println("앞쪽부터 문자열 위치 찾기: " + str.indexOf("def"));
		System.out.println("뒤쪽부터 문자열 위치 찾기: " + str.lastIndexOf("def")); 
		System.out.println("문자열의 길이: " + str.length()); // .length는 변수, .length() 는 메서드
		System.out.println("문자열의 존재 여부 : " + str.contains("def"));
		System.out.println("문자열을 소문자로 변환: " + str.toLowerCase());
		System.out.println("문자열을 대문자로 변환: " + str.toUpperCase());
		System.out.println("문자열 같은지 확인: " + str.equals("abcdefghij")); // false
		System.out.println("문자열 같은지 확인: " + str.equalsIgnoreCase("abcdefghij")); //true 대소문자 구분없이 문자열 자체로만 비교
		
//		System.out.println("문자열의 존재 여부: " + str.toLowerCase().contains("java"));	
		System.out.println("부분 문자열 추출: " + str.substring(7)); // 시작인덱스부터 끝까지 잘라서 반환
		System.out.println("부분 문자열 추출: " + str.substring(7, 10)); // 앞 인덱스 7은 포함 10은 미포함(7,8,9 만 나옴)
		
		char[] crr = str.toCharArray(); // 문자열의 배열을 통쨰로 복사해옴  더 효율적인 코드
		
//		char[] crr = new char[str.length()]; // 이렇게 하면 배열을 두번 만드는 행위 시간낭비 메모리낭비
//		crr = str.toCharArray(); 
		
		str = "cat dog tiger";
		String[] srr = str.split(" "); // 문자열의 배열을 리턴해줌 // 조금 느림
		System.out.println(Arrays.toString(srr));
		
		StringTokenizer st = new StringTokenizer(str, " "); // delimiter도 쓰는게 좋음
		System.out.println(st.nextToken()); // 빠름, 알고리즘할때는 생각해보기 
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
//		String  "#" + testCase + " " + max;  각각 따로따로 상수풀에 다 만들어짐  // 생성할때마다 상수풀에 누적을 함 -> 재사용되지 않는것들은 상수풀에 만들면 낭비임

		// String은 문자열을 이어붙이면 새로만들게 됨
		//		StringBuilder // 내부적으로 더 큰 공간을 가지고 있음 final이 아님. 단일 스레드에서 가장 빠르다. 
//		StringBuffer // 동기화 처리가 되어있다. 
		
		StringBuilder sb;
		sb = new StringBuilder();
		int T = 3;
		int max = 5;
		for(int tc = 1; tc <= T; tc++) {
//			System.out.println("#" + i + " " + max);
//			System.out.println(sb.append("#")
//					.append(i).append(" ").append(max).append('n'));
			sb.append("#").append(tc).append(" ").append(max).append('n');
		}
		System.out.println(sb);
		
		
//		System.out.println(str); // 원본은 항상 그대로임 String 메서드는 원본 변경하지 않음
		
	} // end of main
} // end of class
