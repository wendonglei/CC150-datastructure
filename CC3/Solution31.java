//import java.util.Stack;
import java.util.ArrayList;

public class Solution31{
	public static void main(String args[]){
		SetOfStacks<Integer> test = new SetOfStacks<Integer>(2);
		test.push(new Integer(1));
		test.push(new Integer(2));
		test.push(new Integer(3));
		test.push(new Integer(4));
		test.push(new Integer(5));
		test.push(new Integer(6));
		test.push(new Integer(7));
		test.push(new Integer(8));
		System.out.println("stack value: "+test.popAt(1));
		System.out.println("stack value: "+test.popAt(2));		
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.popAt(0));
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.pop());			

	}
}

class SetOfStacks<T>{
	int capacity;
	ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
		
	public SetOfStacks(int capacity){
		this.capacity=capacity;
	}

	public void push(T value){
		Stack<T> last = getLast();
		if(last==null||last.isfull()){
			last = new Stack<T>(capacity);
			stacks.add(last);
		}
		System.out.println("stack size: "+stacks.size());
		last.push(value);
	}

	public T pop(){
		Stack<T> last= getLast();
		T value = last.pop();
		if(last.isempty()){
			stacks.remove(stacks.size()-1);
		}
		System.out.print("stack size: "+stacks.size());
		return value;
	}

	public T popAt(int index){
		Stack<T> preStack=stacks.get(index);
		T value=preStack.pop();
		for(int i=index+1;i<stacks.size();i++){
			Stack<T> nextStack=stacks.get(i);
			T temp=nextStack.removeBTM();
			preStack.push(temp);
			preStack=nextStack;
		}
		if(preStack.isempty())
			stacks.remove(stacks.size()-1);
		System.out.print("stack size: "+stacks.size());
		return value;
	}

	public Stack<T> getLast(){
		if(stacks.size()==0) return null;
		return stacks.get(stacks.size()-1);
	}

}


class Stack<T>{
	private int capacity;
	private Node<T> top;
	private Node<T> bottom;
	private int size=0;

	public Stack(int capacity){
		this.capacity=capacity;
	}

	public boolean isfull(){
		return size==capacity;
	}

	public boolean isempty(){
		return size==0;
	}	

	public boolean push(T value){
		if(size==capacity) return false;
		Node<T> newnode = new Node<T>(value);
		if(top==null){
			bottom=newnode;
			top=newnode;
		}else{
			newnode.below=top;
			top.above=newnode;
			top=newnode;
		}
		size++;
		return true;	
	}

	public T pop(){
		if(top==null) return null;
		T result=top.value;
		top=top.below;
		if(top!=null)
			top.above=null;
		size--;
		return result;
	}

	public T removeBTM(){
		T result=bottom.value;
		bottom=bottom.above;
		if(bottom!=null)
			bottom.below=null;
		size--;
		return result;
	}
}	 

	class Node<T> {
        public Node<T> above;
        public Node<T> below;
        public T value;
        public Node(T value) {
                this.value = value;
        }
	}