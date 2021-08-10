package 프로그래머스.고득점kit.그리디;

import java.util.Arrays;

public class 체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
        // 여벌 체육복이 있는 학생이 없는 이들에게 체육복 빌려줌
        // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
        // 최대한 많은 학생이 체육수업을 들을 수 있도록 작성

		int answer = n - lost.length;
        
        
        // 테스트케이스 13번 정렬 안된 배열이 들어온 경우
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
//        여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
        // 여벌 체육복 가져온 학생 체육복을 확인
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			lost[i] = -1; // 체크하지 못하도록 -1 대입
        			reserve[j] = -1;
                    answer++;
                    break;
        		}
        	}
        }
        
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
        			answer++;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        
        return answer;
		
//        int length = Math.min(lost.length, reserve.length);
//        
//        for(int i = 0; i < length; i++) {
//        	if (reserve[i]+1 == lost[i] || ((reserve[i]-1 > 1) && reserve[i] - 1 == lost[i])) {
//        		// 만약 1 더한값이 lost와 같거나 1 뺀값이 lost와 같다면
//        		answer++;
//        	}
//        }
        
    }
	
	
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4}; // 잃어버린 학생 번호
		int[] reverse = {1, 3, 5}; // 여벌 있는 학생 번호
		System.out.println(solution(n, lost, reverse));
	}
}
