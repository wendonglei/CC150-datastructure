public class Solution2 {

	public static Node partition (Node n, int x) {
		Node lessStart = null;
		Node cur1=null;
		Node moreStart=null;
		Node cur2=null;
		while(n!=null){
			if(n.data < x) {
				if(lessStart!=null){
					cur1.next=n;
					cur1=cur1.next;
				}else {
					lessStart = n;
					cur1=lessStart;
				}
			}else if(moreStart!=null){
				cur2.next=n;
				cur2=cur2.next;
			}else{
				moreStart=n;
				cur2=moreStart;
			}

			n=n.next;
		}

		if(lessStart==null) {
			return moreStart;
		}

		cur1.next=moreStart;
		cur2.next=null;
		return lessStart;
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
		int k= 7;
		System.out.println("Original List : "+k);		
		Node newone = partition(n,k);

		while(newone!=null){
			System.out.println(newone.data);
			newone=newone.next;
		}
				
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