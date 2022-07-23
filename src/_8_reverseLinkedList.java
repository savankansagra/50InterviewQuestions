import java.util.*;

public class _8_reverseLinkedList {
    static class Node {
    	int data;
        Node next;
        Node(int data){this.data = data; this.next = null;}
        Node(int data, Node next){this.data = data; this.next = next;}
    }
  
    static class LinkedList {
        Node head;
        LinkedList(){this.head = null;}
        LinkedList(Node head){this.head = head;}
    }
    
    public void reverseList(LinkedList list){
        Node pre = null;
        Node current = list.head;
        Node next = list.head.next;
        while(current != null) {
        	current.next = pre;  //swap the pointer
        	pre = current;
        	current = next;
        	if(current != null) {
        		next = current.next;
        	}
        }
        list.head = pre;
    }
    
    public static void main(String[] args) {
		_8_reverseLinkedList _8_reverseLinkedListOb = new _8_reverseLinkedList();
		Node node = new Node(10,new Node(20, new Node(30)));
		LinkedList sampleList = new LinkedList(node);
		_8_reverseLinkedListOb.reverseList(sampleList);
		System.out.println(sampleList);
		
	}
    
}