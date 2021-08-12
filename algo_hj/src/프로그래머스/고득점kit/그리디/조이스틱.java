package 프로그래머스.고득점kit.그리디;

public class 조이스틱 {
	public static int solution(String name) {
        int answer = 0;
        int min_move = name.length()-1; 
        // 조이스틱으로 알파벳 이름을 완성. 맨 처음엔 A로만 이루어져 있음 ex) 3글자 AAA 4글자 AAAA
        // up - 다음 알파벳, down - 이전 알파벳(A에서 아래로 이동하면 Z로)
        // left - 커서 왼쪽 , right - 커서 오른쪽
        
        // 만들고자 하는 이름이 name 매개변수 일 때 이름에 대해 조이스틱 조작 횟수의 최소값을 return
        
        for(int i = 0; i < name.length(); i++) {
        	if(name.charAt(i) <= 'M') {
        		// M이 딱 절반 13번째 알파벳
        		answer += name.charAt(i) - 'A'; // 해당하는 인덱스만큼 더해줌
        	} else {
        		// 여기는 절반 보다 큰경우므로 거꾸로 빼서 더해주기
        		answer += 'Z' - name.charAt(i) + 1;
        	}
        	
        	// left, right 처리
        	// A인 경우와 Z 인 경우??
        	int idx = i + 1;
        	while(idx < name.length() && name.charAt(idx) == 'A') {
        		// 예시에서 AZ처럼 다음 원소가 A인 경우
        		System.out.println("idx???: " + idx);
        		idx++;
        	}
        	System.out.println("answer : " + answer);
        	min_move = Math.min(min_move,  i + name.length() - idx + Math.min(i, name.length() - idx));
        	System.out.println("min_move: " + min_move);
        	
        	// name.length() - idx : 
        	// 총 길이에서 현재 바로 다음에 연속된 A가 지나고 남은 문자 갯수
        	// i : 오른쪽으로의 현재까지의 이동횟수
        	// i + name.length() - idx + i : 현재까지 왔다가 다시 돌아가서 남은 거 까지 가는 이동 횟수
        	// min(i,name.length()-idx)에서,
        	// i 보다 name.length()-idx 값이 작은 경우에 name.length()-idx 선택하는데
        	// 이는, 마지막 문자가 A인 경우를 제외 하면
        	// 무조건 name.length()-1 보다 크게 된다 (name.length()-idx >=1)
        	// 따라서,i가 name.length()-idx(남은 문자)보다 큰 경우는
        	// 굳이 왼쪽으로 다시 돌아갈 필요가 없다.
        	// 대신 끝이 A인 경우는, name.length()-idx 0이 되므로,
        	// 무조건 name.length()-1 보다 작은 i 가 최소 이동횟수가 된다.
        	// 따라서 Math.min(i,name.length()-idx) 이 부분은 식에서 필요하게 된다.
        } // end of for
        
        answer += min_move;
        return answer;
    }
	
	public static void main(String[] args) {
		
		String name = "JEROEN";
//		String name = "JAN";
		System.out.println(solution(name));
	}
}
