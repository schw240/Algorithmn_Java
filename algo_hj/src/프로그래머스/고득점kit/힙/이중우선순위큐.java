package 프로그래머스.고득점kit.힙;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public static int[] solution(String[] operations) {
        
        // 명령어 l 숫자: 큐에 주어진 숫자 삽입
        // D 1 : 큐에서 최대값 삭제
        // D -1: 큐에서 최솟값 삭제
        int[] answer = {0,0}; // 비어있으면 0,0 반환
        PriorityQueue<Integer> minQ = new PriorityQueue();
        PriorityQueue<Integer> maxQ = new PriorityQueue(Collections.reverseOrder());
        
        int val = 0;
        
        // 연산을 처리한 후 큐가 비어있으면 [0,0], 아니면 [최대,최소]
        for(int i = 0; i < operations.length; i++){
            String command = operations[i];
//        	System.out.println(command); //명령어 확인
            String kind = command.substring(0,1); // 연산하는 종류 삽입인지 삭제인지
//            System.out.println(kind);
            // 삭제
            if(kind.equals("D")) {
                // 최솟값 삭제
                if(command.charAt(2) == '-') { // 최소값
                    if(!minQ.isEmpty()) {
                        val = minQ.peek();
//                        System.out.println(val);
                        minQ.poll();
                        maxQ.remove(val);
                    }
                }
                // 최댓값 삭제
                else {
                    if(!maxQ.isEmpty()) {
                        val = maxQ.peek();
                        maxQ.poll();
                        minQ.remove(val);
                    }
                }
            }
            else {  // 추가
                int value = Integer.parseInt(command.substring(2));
                maxQ.offer(value);
                minQ.offer(value);
            }
        }
        // 큐가 비어있지 않으면 [최댓값, 최솟값]
        if(!maxQ.isEmpty()){
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
//		String[] operations = {"I 16", "D 1"};
		String[] operations = {"I 7","I 5","I -5","D -1"};
	
		System.out.println(Arrays.toString(solution(operations)));
	
	}
}
