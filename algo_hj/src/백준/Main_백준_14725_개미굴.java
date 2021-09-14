package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Main_백준_14725_개미굴 {
		
	static int N;

	public static void main(String[] args) throws Exception {

		
		// 개미굴의 각 층 방을 따라 내려가다가 더이상 내려갈 수 없으면 그자리에서 움직이지 않고 신호보냄
		// 내려오면서 알게된 각 방의 먹이 정보 알려주기
		
		// 개미굴의 각 층은 --으로 구분 
		// 1층은 없고
		// 2층부터 --
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 먹이 정보 개수 N
		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie(); // 트라이 자료구조 생성

		for (int i = 0; i < N; i++) { // N개만큼 각 줄의 시작은 로봇 개미 한마리가 보내준 먹이 정부 개수 K
			String[] input = br.readLine().split(" ");

			int K = Integer.parseInt(input[0]); // 먹이정보 개수 K
			int[] arr = new int[K];

			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= K; j++) { // K개 입력으로 로봇 개미가 왼쪽부터 순서대로 각 층마다 지나온 방에 있는 먹이 정보
				sb.append(input[j]); // 문자열 합쳐주기
				arr[j - 1] = input[j].length(); // 문자열을 넣어주므로 어디에서 끊을지 알려주기 위한 arr배열
			}

			trie.insert(sb.toString(), arr); 

		}

		trie.print();

	}

	static class Trie {

		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word, int[] arr) {

			TrieNode thisNode = rootNode;

			int idx = 0;
			for (int i = 0; i < arr.length; i++) { // arr 길이가 들어있는 문자열 개수
				String str = word.substring(idx, idx + arr[i]); // 문자열 나눠주기
				idx = idx + arr[i];
//				System.out.println("단어 확인: " + str);

				// 여기까지를 끝으로 하는 단어가 존재한다고 표시해주기 
				thisNode = thisNode.getChildNodes().computeIfAbsent(str, key -> new TrieNode()); // 람다식
			}
			thisNode.setIstLastChar(true);
		}

		public void print() {
			print(rootNode, 0);
		}

		public void print(TrieNode thisNode, int floor) {

			Set<String> set = thisNode.getChildNodes().keySet();
			Iterator<String> it = set.iterator();

			while (it.hasNext()) {
				String str = it.next();

				TrieNode childNode = thisNode.getChildNodes().get(str);
				for (int i = 0; i < floor; i++)
					System.out.print("--");
				System.out.println(str);
				print(childNode, floor + 1);

			}
		}
	}

	static class TrieNode {

		Map<String, TrieNode> childNodes = new TreeMap<>();
		boolean isLastChar;

		Map<String, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setIstLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public boolean isLastChar() {
			return isLastChar;
		}
	}
		
}
