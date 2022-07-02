
public class _7_reverseBinaryTree {
	Tree root;

	static class Tree {
		int data;
		Tree left;
		Tree right;
		
		//constructors
		Tree(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		Tree(int data, Tree left, Tree right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public void reverseTree(Tree root){
		
	}

	private Tree addRecursive(Tree current, int value) {
		if(current == null) {
			return new Tree(value);
		}
		if(current.left == null){
			current.left = addRecursive(current.left, value);
		} else if(current.right == null){
			current.right = addRecursive(current.right, value);
		} else {
			addRecursive(current.left,value);
		}
		return current;
	}

	public void add(int value){
		root = addRecursive(root, value);
	}

	public static void main(String[] args) {
		_7_reverseBinaryTree BTree = new _7_reverseBinaryTree();
		BTree.add(1);
		BTree.add(2);
		BTree.add(3);
		BTree.add(4);
		BTree.add(5);
		BTree.add(6);
		BTree.add(7);
	}
}
