public class Solution5 {
	public static boolean isPalindrome(Node head) {
		Node slow=head;
		Node fast=head;
		Node reverse=null;
		if(head==null||head.next==null)
			return true;
		while(fast!=null&&fast.next!=null){
			Node temp = new Node(slow.data);
			temp.next=reverse;
			reverse=temp;
			slow=slow.next;
			fast=fast.next.next;
		}

		if(fast!=null) {
			slow=slow.next;
		}

		while(slow!=null){
			if(slow.data!=reverse.data)
				return false;
			slow=slow.next;
			reverse=reverse.next;
		}
		return true;
	}

public static void main(String args[]){
		Node a = new Node(1);
		a.next = new Node(2);
		a.next.next = new Node(2);
		a.next.next.next = new Node(1);
		//Node start=a;
		//a.next.next.next.next = new Node(1);
		//a.next.next.next.next.next = new Node(1);
		
		System.out.println("results : "+isPalindrome(a));		

				
	}
}
	class Node{
		int data;
		Node next;
		public Node(int a){
			data = a;
			next = null;
		}
	}