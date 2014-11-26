package src;

public class BinaryTree {
	
	Node root;		// Root node of tree
	
	/*
	 * Constructor for BinaryTree using root val to initialize
	 */
	public BinaryTree(int val) {
		this.root = new Node(val);
	}
	
	/*
	 * Constructor for BinaryTree using array of values to
	 * initialize, with first val as root
	 */
	public BinaryTree(int[] vals) {
		this.root = new Node(vals[0]);
		for (int i=1; i<vals.length; i++) {
			this.append(vals[i]);
		}
	}
	
	/*
	 * Visible driver for DFS of tree,
	 * marks values as final for write protection
	 * 
	 * Returns Node with value specified
	 */
	Node search(BinaryTree tree, int val) {
		final BinaryTree TREE = tree;
		final int VAL = val;
		return search(TREE.root, VAL);
	}
	
	/*
	 * Recursive DFS using root from driver as start
	 */
	private Node search(Node n, int VAL) {
		if (n == null) {
			return null;
		} else if (n.val == VAL) {
			return n;
		} else {
			Node leftLookup = search(n.left, VAL);
			Node rightLookup = search(n.right, VAL);
			if (leftLookup != null) {
				return leftLookup;
			} else if (rightLookup != null) {
				return rightLookup;				
			}
			return null;
		}
	}
	
	/*
	 * Appends the given value to the tree using an
	 * ordered approach
	 */
	void append(int val) {
		Node k = this.root;
		while(true) {
			if (val < k.val) {
				if (k.left != null) {
					k = k.left;
				} else {
					k.left = new Node(val);
					break;
				}
			} else {
				if (k.right != null) {
					k = k.right;
				} else {
					k.right = new Node(val);
					break;
				}
			}
		}
	}
	
	/*
	 * Visible driver for printing DFS of tree
	 */
	void printGraph() {
		printGraph(this.root);
	}
	
	/*
	 * Prints nodes from tree in DFS order
	 */
	private void printGraph(Node k) {
		if (k.left != null) {
			printGraph(k.left);
		}
		System.out.println(k.val);
		if (k.right != null) {
			printGraph(k.right);
		}
	}
	
	void printLeaf(Node goal) {
		String visited = "Leaf:";
		printLeaf(this.root, goal, visited);
	}
	
	private void printLeaf(Node n, Node goal, String visited) {
		visited += " " + n.val;
		if (n.equals(goal)) {
			System.out.println(visited);
		}
		if (n.right != null) {
			printLeaf(n.right, goal, visited);
		}
		if (n.left != null) { 
			printLeaf(n.left, goal, visited);
		}
	}
	
	/*
		public static void main(String[] args) {
			int[] vals = {100, 0, 10, 120, 80, 5, 200};
			BinaryTree bt = new BinaryTree(vals);
			bt.printGraph();
			Node k = bt.search(bt, 200);
			bt.printLeaf(k);
		}
	*/
	
}
