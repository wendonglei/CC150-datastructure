public class Solution4 {
	public static Node findBegining(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				break;
		}

		if(fast==null||fast.next==null){
			return null;
		}

		slow=head;
		int count=0;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
			count++;
			if(slow==fast)
				break;
		}

		return slow;
	}

public static void main(String args[]){
		Node a = new Node(1);
		a.next = new Node(2);
		a.next.next = new Node(3);
		a.next.next.next = new Node(4);
		Node start=a;
		a.next.next.next.next = new Node(5);
		a.next.next.next.next.next = new Node(6);
		a.next.next.next.next.next.next = start;
		Node result=findBegining(a);
		System.out.println("results : "+result.data);		

				
	}
	static class Node{
		int data;
		Node next;
		public Node(int a){
			data = a;
			next = null;
		}
	}

}

