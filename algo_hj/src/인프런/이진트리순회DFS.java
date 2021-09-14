package 인프런;

//class Node {
//	int data;
//	Node lt, rt;
//	public Node(int val) {
//		data = val;
//		lt = rt = null;
//	}
//}

public class 이진트리순회DFS {
	Node root;
	public void dfs(Node root) {
		if(root == null) return;
		else {
			System.out.print(root.data + " ");
			dfs(root.lt);
			dfs(root.rt);
		}
	}
	
	public static void main(String[] args) {
		이진트리순회DFS tree = new 이진트리순회DFS();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.dfs(tree.root);
		
	}
}
