package ch.zhaw.lzw.compress;

class Node implements Comparable {
	private int value;
	private char content;
	private Node left;
	private Node right;

	public Node(char content, int value) {
		this.content = content;
		this.value = value;
	}

	public Node(Node left, Node right) {
		// Assumes that the left three is always the one that is lowest
		this.content = (left.content < right.content) ? left.content
				: right.content;
		this.value = left.value + right.value;
		this.left = left;
		this.right = right;
	}

	public int compareTo(Object arg) {
		Node other = (Node) arg;

		// Content value has priority and then the lowest letter
		if (this.value == other.value)
			return this.content - other.content;
		else
			return this.value - other.value;
	}

	// //////////////

	private void printNode(String path) {
		if ((left == null) && (right == null))
			System.out.println(content + " " + path);

		if (left != null)
			left.printNode(path + '0');
		if (right != null)
			right.printNode(path + '1');
	}

	public static void printTree(Node tree) {
		tree.printNode("");
	}
}