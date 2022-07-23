
public class _12_palindrome_linkedList {
	static class Node implements Cloneable{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		//clone method
		@Override
		protected Node clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			Node cloned = (Node)super.clone();
			if(cloned.next != null) {
				cloned.next = cloned.next.clone();
			} 
			return cloned;
		}
	}
	
	public static void main(String[] args) {
		//Test case one
		Node Case1 = new Node(1, 
				new Node(4,
						new Node(6, 
								new Node(5, 
										new Node(6, 
												new Node(4, 
														new Node(1)))))));
		System.out.println(Case1);
		boolean result = isPalindromeList(Case1);
		System.out.println(result);
	}

	private static boolean isPalindromeList(_12_palindrome_linkedList.Node case1){
		//reverse the current linked list
		Node caseR=null;
		try {
			caseR = case1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Node pre = null;
		Node current = caseR;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		// pre is the starting of the list		
		
		
		//check for same node in both lists
		boolean resultFlag = true;
		while(case1.next != null && pre.next != null) {
			if(case1.data != pre.data) {
				resultFlag = false;
				break;
			} else {
				case1 = case1.next;
				pre = pre.next;
			}
		}
		
		return resultFlag;
	}
}
