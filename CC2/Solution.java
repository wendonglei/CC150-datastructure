public class Solution {
	public static Node getKthNode(Node head, int k) {
		Node cur = head;
		while(k>0){
			if(cur ==null){
				System.out.println("linkedlist too short");
				return null;
			}else {
				cur = cur.next;
				k--;
			}
		}

		while (cur!=null) {
			cur =cur.next;
			head = head.next;
		}

		return head;
	}


	public static void main(String args[]){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(7);
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		n.next.next.next.next.next.next.next = new Node(12);
		System.out.print("Original List : ");		
		System.out.print("\n Iteration::3th Element from the end is : " + getKthNode(n, 2).data);
				
	}

	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			next = null;
		}
	}

}