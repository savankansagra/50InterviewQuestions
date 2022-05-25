import java.util.ArrayList;
import java.util.List;

public class _5_treeOrders {

	    static class Tree{
	        int data;
	        Tree left;
	        Tree right;
	        Tree(int data){this.data = data; this.left = null; this.right = null;}
	        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
	    }
	      
	    /*
	     * DFS in pre-order => root, left, right
	     */
	    public void dfsPreorder(Tree root){
	    	List<Integer> resultList = new ArrayList<>();
	    	dfsPreorderRecursive(root, resultList);
	    	
	    	printArray(resultList);
	    }
	      
	    private int dfsPreorderRecursive(_5_treeOrders.Tree root, List<Integer> resultList) {
	    	if(root == null) {
	    		return 0;
	    	}
			resultList.add(root.data);
			if(root.left != null) {
				dfsPreorderRecursive(root.left, resultList);
			} 
			if(root.right != null) {
				dfsPreorderRecursive(root.right, resultList);
			}
			return 1;
			
		}

	    /*
	     * DFS Inorder => left, root, right
	     */
		public void dfsInorder(Tree root){
			List<Integer> resultList = new ArrayList<>();
			defInorderRecursive(root, resultList);
			
			printArray(resultList);
	    }
		
		
	     
	    private int defInorderRecursive(_5_treeOrders.Tree root, List<Integer> resultList) {
			if(root == null ) {
				return 0;
			}
			//--left call
			if(root.left != null) {
				defInorderRecursive(root.left, resultList);
			}
			//--root add
			resultList.add(root.data);
			//--right call
			if(root.right != null) {
				defInorderRecursive(root.right, resultList);
			}
			
			return 1;
		}

	    
	    /*
	     * DFS in post order => left, right, root
	     */
		public void dfsPostorder(Tree root){
			List<Integer> resultList = new ArrayList<>();
			
			dfsPostorderRecursive(root,resultList);
			
			printArray(resultList);
	    }
		
		
		private int dfsPostorderRecursive(_5_treeOrders.Tree root, List<Integer> resultList) {
			if(root == null ) {
				return 0;
			}
			//--left call
			if(root.left != null) {
				dfsPostorderRecursive(root.left, resultList);
			}
			//--right call
			if(root.right != null) {
				dfsPostorderRecursive(root.right, resultList);
			}
			//--root add
			resultList.add(root.data);
			
			
			return 1;
			
		}

		//Print the result list.
		public void printArray(List<Integer> input ) {
			System.out.print(" [ ");
			for(int k=0;k<input.size();k++) {
				System.out.print(input.get(k)+", ");
			}
			System.out.print("]");
		}
	    
	    
	    /*
	     *  main method for testing
	     */
	    public static void main(String[] args) {
	    	Tree inputTree = new Tree(1, new Tree(2, new Tree(4, null, null), new Tree(5, null, null)),
	    			new Tree(3, new Tree(6, null, null), new Tree(7, null, null))
	    			);
	    	_5_treeOrders _5_treeOrdersOb = new _5_treeOrders();
	    	//_5_treeOrdersOb.dfsPreorder(inputTree);
	    	//_5_treeOrdersOb.dfsInorder(inputTree);
	    	 _5_treeOrdersOb.dfsPostorder(inputTree);
	    
		}
}
