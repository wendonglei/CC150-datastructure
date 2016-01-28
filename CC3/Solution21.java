import java.util.Stack;

public class Solution21{

	public static void main(String args[]){
		StackwithMin<String> test = new StackwithMin<String>();
		test.push(new String("a"));
		System.out.println("minimum is :"+test.getMin());
		test.push(new String("ba"));
		System.out.println("minimum is :"+test.getMin());
		test.push(new String("acs"));
		System.out.println("minimum is :"+test.getMin());
		test.push(new String("dfs"));
		System.out.println("minimum is :"+test.getMin());
		test.pop();
		System.out.println("minimum is :"+test.getMin());
		test.pop();
		System.out.println("minimum is :"+test.getMin());							
	}

}
class StackwithMin<T extends Comparable<T>> extends Stack<T> {
	private Stack<T> minStack = new Stack<T>();
	//Stack dataStack = new Stack<T>();
	public T push(T value) {
		/*if(minStack.empty())
			minStack.push(value);
		else {
			T min=minStack.peek();
			if(value.compareTo(min)<=0) {
				minStack.push(value);
			}
		} */

		if(minStack.empty()||value.compareTo(minStack.peek())<=0) {
			minStack.push(value);
		}
		
		super.push(value);
		return value;
	}

	public T pop(){
		T value = super.pop();
		T premin = minStack.peek();
		if(value.compareTo(premin)==0){
			minStack.pop();
		}
		return value;
	}

	public T getMin(){
		return minStack.peek();
	}
}
