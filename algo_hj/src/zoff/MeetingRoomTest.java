package zoff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomTest {
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			int value = this.end - o.end; // 내거에서 상대거를 빼기
			if(value != 0) return value; // 종료시간이 다르면
			return this.start - o.start; // 종료시간이 같다면 시작시간이 빠른순서로.
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] meetings = new Meeting[N];
		for(int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		
		for(Meeting meeting : getSchedule(meetings)) {
			System.out.println(meeting);
		}
		
		
	}
	
	
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
		ArrayList<Meeting> list = new ArrayList<>();
		
		Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
		
		list.add(meetings[0]); // 청회의 추가
		
		for(int i = 1, size = meetings.length; i < size; i++) {
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}
}
