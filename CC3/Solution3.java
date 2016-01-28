import java.util.Stack;
import java.util.ArrayList;

public class Solution3{

	public static void main(String args[]){
		SetOfStack<Integer> test = new SetOfStack<Integer>(2);
		test.push(new Integer(1));
		test.push(new Integer(2));
		test.push(new Integer(3));
		test.push(new Integer(4));
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.pop());
		System.out.println("stack value: "+test.pop());

	}

	private static class SetOfStack<T>{
		ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
		//Stack<T> curstack = new Stack<T>();
		private int capacity=0; 

		public SetOfStack(int capacity){
			this.capacity=capacity;
		}
		public void push(T value){
			Stack<T> curstack= getLast();
			if(curstack==null||curstack.size()>=capacity){
				//stacks.add(curstack);
				curstack=new Stack<T>();
				stacks.add(curstack);
			}
			curstack.push(value);
			System.out.println("stack size: "+stacks.size());
		}

		public Stack<T> getLast(){
			if(stacks.size()==0) return null;
			return stacks.get(stacks.size()-1);
		}
		public T pop(){
			Stack<T> curstack= getLast();
			T value = curstack.pop();
			if(curstack.size()==0){
				stacks.remove(stacks.size()-1);
			}
			System.out.println("stack size: "+stacks.size());
			return value;
		}

		//public T popAt(int index){
		//	if(index)
		//}
	}
}