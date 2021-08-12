package zoff;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 순열: 3~5개 반복문, 재귀함수
 * 조합: 반복문, 재귀함수
 * 부분집합: 반복문, 바이너리 카운팅(비트마스킹), 재귀함수
 * 
 * 정렬 : 
 * 		O[N^2] 선택정렬, 버블정렬(거품정렬), 삽입정렬
 * 		O[NlogN] 퀵정렬, 병합정렬, 힙정렬 
 * 		O[N] 카운팅 정렬(가장 빠름 하지만 비교하려는 원소들이 양의 정수일 경우에만 가능함 또한 메모리를 많이 차지하므로 사용처가 제한적)
 * 
 * 
 * 공부용 사이트: https://visualgo.net
 */


public class SortTest {
	// comparable, comparator
	
//	static int[] arr = {2, 7, 4, 9, 1, 3, 5};
	
	private static void swap(int[] arr, int i, int j) {
		int temp;
		
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static void main(String[] args) {
		// 선택 정렬: 가장 오래된 정렬 알고리즘으로 성능이 안좋아서 이제 쓰이지 않음(교육용)
		// 정렬 방법: 영역의 범위 중 최소값을 찾아서 영역의 맨 앞으로 이동
		// 			최소값 위치 찾기, swap
		
		// 0 ~ n 범위의 최소값 위치를 찾아서 0번 위치로 교환
		// 1 ~ n 범위의 최소값 위치를 찾아서 1번 위치로 교환
		// 2 ~ n 범위의 최소값 위치를 찾아서 2번 위치로 교환
		// ...
		// n-1 ~ n 범위의 최소값 위치를 찾아서 n-1 번 위치로 교환
		// n ~ n 범위의 최소값 위치를 찾아서 n 번 위치로 교환 -> 근데 마지막은 안해도 됨 어짜피 정렬된 상태
		
		// 1 ||  7 4 9 2 3 5
		// 1 2 || 4 9 7 3 5
		// 1 2 3 || 9 7 4 5
		// 1 2 3 4 || 7 9 5
		
//		int[] arr = {2, 7, 4, 9, 1, 3, 5};

//		System.out.println(Arrays.toString(arr)); // 배열 출력
		
//		for(int i = 0; i < arr.length; i++) {  내코드
//			for(int j = i+1; j < arr.length; j++) {
//				if (arr[i] > arr[j]) {
//					swap(arr, i, j);
//				}
//			}
//		}
		
//		for(int i = 0; i < arr.length-1; i++) { // 0 ~ n-1: 시작 숫자  // 교수님 코드 
//			// i ~ n  영역의 최소값 위치를 찾아서  arr[i] ~ arr[minIndex]
//			int minIndex = i; // 최소값 위치
//			for(int j = i+1; j < arr.length; j++) { // 영역에서 최소값 위치 찾기
//				if(arr[minIndex] > arr[j]) { // 뒤에있는게 더 작아서 바꿔야하는 경우 찾기
//					minIndex = j; // 찾았으면 인덱스 값 수정해주기
//				}
//			}
//			
//			int temp = arr[minIndex];
//			arr[minIndex] = arr[i];
//			arr[i] = temp;
//			
//			
//		}
//		System.out.println(Arrays.toString(arr)); // 배열 출력 정렬 후
		

		
		Fruit[] arr = { new Fruit(2000, "사과"),
						new Fruit(7000, "파인애플"),
						new Fruit(4000, "배"),
						new Fruit(9000, "수박"),
						new Fruit(1000, "귤")
						};
//		System.out.println(Arrays.toString(arr)); // 확인용 출력
////		Arrays.sort(arr); // 에러가 남 -> 캐스팅 에러 (클래스형은 comparable 하지가 않음)
//		Arrays.sort(arr); // 클래스 안 compareTo를 구현해야지 안에 구현된 내용으로 클래스 정렬 가능
		System.out.println(Arrays.toString(arr)); 
		
		
//		for(int i = 0; i < arr.length-1; i++) { // 0 ~ n-1: 시작 숫자  // 교수님 코드 
//		// i ~ n  영역의 최소값 위치를 찾아서  arr[i] ~ arr[minIndex]
//		int minIndex = i; // 최소값 위치
//		for(int j = i+1; j < arr.length; j++) { // 영역에서 최소값 위치 찾기
//			if(arr[minIndex].compareTo(arr[j]) > 0 ) { // compareTo가 이렇게 활용 됨 만약 둘이 비교해서 앞에게 더 크면 1 반환되므로 0보다 큼 // 뒤에있는게 더 작아서 바꿔야하는 경우 찾기
//				minIndex = j; // 찾았으면 인덱스 값 수정해주기
//			}
//		}
//		
//		Fruit temp = arr[minIndex];
//		arr[minIndex] = arr[i];
//		arr[i] = temp;
//		
//		
//	}
	
//	Arrays.sort(arr); // 정렬 내부비교기(Comparable 의 compareTo())를사용
	// 정렬, 외부비교기(Comparator의 compare())를 사용
		
	// 클래스 안에 내부 비교기를 만들어뒀다고 하더라도 이렇게 다시 외부 비교기를 구현해서 사용하면 외부비교기가 우선순위가 더 높음
	Arrays.sort(arr, new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) { // o1(this), o2(other)
			
			return o1.price - o2.price; // 오름차순
		}
		
	});
		
	System.out.println(Arrays.toString(arr)); // 정렬 후
		
	} // end of main
} // end of class


class Fruit implements Comparable<Fruit> { // Comparable에 f3눌러서 내부 코드 살펴보기
	int price;
	String name;
	
	public Fruit() {}
	
	public Fruit(int price, String name) {
		this.price = price;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + name + ":" + price + "] ";
	}

	@Override
	/** return this - other 오름 차순 */ 
	public int compareTo(Fruit other) { // this, other 나와 너를 비교해서 기본적으로는 오름차순으로 정렬이 됨
		// TODO Auto-generated method stub
//		return this.price - other.price; // price를 기준으로 오름차순 출력해주기
//		return (this.price - other.price) * -1; // 가격에 대한 내림차순
//		return this.name - other.name; // String이라서 문자열 비교 안됌
//		return this.name.compareTo(other.name); // 기본적으로는 항상 오름차순 비교
		return - this.name.compareTo(other.name); // 내림차순
		
	}
	
}
