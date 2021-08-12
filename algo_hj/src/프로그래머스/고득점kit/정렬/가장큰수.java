package 프로그래머스.고득점kit.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			// 정수들을 문자열로 바꿔서 넣어줌
			// arr[i] = String.valueOf(numbers[i]);
            arr[i] = numbers[i] + "";
		}
//		System.out.println(Arrays.toString(arr));
		
		// 정렬
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				// o2 + o1가 더 크다면 자리를 바꿔줌(1 반환) 반대로 o2 + o1이 o1 + o2보다 작다면 음수반환 내림차순 정렬 
				return (o2+o1).compareTo(o1+o2);
			}
		});
//		System.out.println(Arrays.toString(arr));
		
        StringBuilder sb = new StringBuilder();
		
		for(String s : arr) {
			// answer += s;
            sb.append(s);
		}
        if(sb.charAt(0) == '0') {
        	return "0";
        }
        return sb.toString();
	}
	


	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {90,908,89,898,10,101,1,8,9};
		// 9, 90, 908, 89, 898, 8, 1, 101, 10
		System.out.println(solution(numbers));
	}
}
