package zoff;

import java.util.LinkedList;
import java.util.Queue;

public class 트리탐색BFS {
	
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public 트리탐색BFS(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
	}
	
	
	public void add(char c) {
		
		if(lastIndex==SIZE) return; // 꽉찬상황
		
		nodes[++lastIndex] = c;
		
	}
	
	public void bfs() {
		
		// 탐색을 기다리는 노드들이 저장됨
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); // 루트노드 인덱스 저장
		
		int cur = 0;
		while(q.size() > 0) {
			
			cur = q.poll();
			System.out.println(nodes[cur]);
			
			// 왼쪽 자식이 있다면
			if(cur * 2 <= lastIndex) q.offer(cur * 2);
			// 오른쪽 자식이 있다면
			if(cur * 2 + 1 <= lastIndex) q.offer(cur * 2 + 1);
			
			
		}
		
		
		
	}
	
	
	
}
