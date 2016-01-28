import java.util.Stack;
 public class Solution5{

 	public static void main(String args[]){
 		MyQueue<Integer> test = new MyQueue<Integer>();
 		test.add(new Integer(1));
 		test.add(new Integer(2));
 		System.out.println("Pop:"+ test.peek());
 		test.add(new Integer(3));
 		System.out.println("Pop:"+ test.remove());
 		System.out.println("Pop:"+ test.remove());
 		test.add(new Integer(4));
 		test.add(new Integer(5));
 		System.out.println("Pop:"+ test.peek());
 	}

 }

class MyQueue<T>{
 	Stack<T> normal = new Stack<T>();
	Stack<T> reverse = new Stack<T>();

	public void add(T value){
		normal.push(value);
	}

	public T remove(){
		if(reverse.empty()){
			while(!normal.empty()){
				reverse.push(normal.pop());
			}
		}

		return reverse.pop();
	}

	public T peek(){
		if(reverse.empty()){
			while(!normal.empty()){
				reverse.push(normal.pop());
			}
		}

		return reverse.peek();		
	}
 }