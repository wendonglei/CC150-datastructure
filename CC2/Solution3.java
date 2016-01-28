public class Solution3 {
	public static int carry2=0;
	public static Node addList(Node a, Node b, int carry) {
		if(a==null&&b==null&&carry==0) {
			return null;
		}
		int sum = carry;
		if(a!=null)
			sum+=a.data;
		if(b!=null)
			sum+=b.data;
		Node newNode = new Node(sum%10);
		//if(a!=null||b!=null)
			newNode.next = addList(a==null ? null:a.next, b==null ? null:b.next, sum>=10 ? 1:0);
		return newNode;
	}

	public static Node addList2(Node a, Node b) {
		int aLen=getLength(a);
		int bLen=getLength(b);
		if(aLen>bLen){
			int count = aLen-bLen;
			while(count>0) {
				Node n = new Node(0);
				n.next = b;
				b=n;
				count--;
			}			
		}
		
		if(aLen<bLen){
			int count = bLen-aLen;
			while(count>0) {
				Node n = new Node(0);
				n.next = a;
				a=n;
				count--;
			}
				
		}	

		Node result = addRecursive(a,b);
		if(carry2==1){
			Node extra = new Node(1);
			extra.next=result;
			result=extra;
		}
			
		return result;
	}
	public static Node addRecursive(Node a, Node b) {
		if(a==null&&b==null)
			return null;

		Node append = addRecursive(a.next,b.next);
		int sum = a.data+b.data+carry2;
		if(sum>=10) {
			carry2=1;
		}else {
			carry2=0;
		}

		Node pre = new Node(sum%10);
		pre.next = append; 
		return pre;
	}

	public static int getLength(Node a){
		int len=0;
		while(a!=null){
			len++;
			a=a.next;
		}

		return len;
	}

	public static void main(String args[]){
		Node a = new Node(8);
		//a.next = new Node(9);
		//a.next.next = new Node(9);
		//a.next.next.next = new Node(9);
		Node b = new Node(9);
		b.next = new Node(9); 
		b.next.next = new Node(9);
		b.next.next.next = new Node(2);
		Node result=addList2(a,b);
		System.out.println("results : ");		

		while(result!=null){
			System.out.println(result.data);
			result=result.next;
		}
				
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