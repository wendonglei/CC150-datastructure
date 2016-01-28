public class Solution2{

	public static void main(String args[]){
		StackMin stack = new StackMin();
		try{
		stack.push(1);
		System.out.println("minimum is :"+stack.getMin());
		stack.push(2);
		System.out.println("minimum is :"+stack.getMin());
		stack.push(3);
		System.out.println("minimum is :"+stack.getMin());
		stack.push(4);
		System.out.println("minimum is :"+stack.getMin());
		stack.pop();
		System.out.println("minimum is :"+stack.getMin());
		stack.pop();
		System.out.println("minimum is :"+stack.getMin());			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

class StackMin{
	private Node head=null;
	public void push(int value){
		Node newnode= new Node(value);
		if(head==null){
			head=newnode;
		}
			
		if(value<head.localmin){
			newnode.localmin=value;			
		}else{
			newnode.localmin=head.localmin;
		}
		newnode.next=head;
		head=newnode;
	}

	public int pop() throws Exception{
		if(head==null)
			throw new Exception("empty stack");
		int value=head.data;
		head=head.next;
		return value;
	}
	public int getMin() throws Exception{
		if(head==null)
			throw new Exception("empty stack");
		return head.localmin;			
	}

	private class Node{
		int data;
		int localmin=Integer.MAX_VALUE;
		Node next;
		public Node(int data){
			this.data = data;
			next = null;
		}
	}	
}
