import java.util.Stack;
 public class Solution6{

 	public static void main(String args[]){
 		Stack<String> test = new Stack<String>();
 		test.push("f");
 		test.push("a");
 		test.push("d");
 		test.push("de");
 		test.push("c");
 		test.push("af");
 		test.push("b");

 		//System.out.println("a".compareTo("ac"));
 		/*Stack<Integer> test = new Stack<Integer>();
 		test.push(2);
 		test.push(3);
 		test.push(4); 
 		test.push(1);
 		test.push(6);	*/		
 		test = sort(test);
 		/*for(String a:test){
 			System.out.println(a);
 		}*/

 		while(!test.empty())
 			System.out.println(test.pop());
 	}

 	public static <T extends Comparable<T>> Stack<T> sort(Stack<T> target){
 		Stack<T> buffer = new Stack<T>(); 		
 		while(!target.empty()){
 			T temp = target.pop();
 				while(!buffer.empty()&&temp.compareTo(buffer.peek())<0){
					target.push(buffer.pop());
 			}
 			buffer.push(temp);
 		}
 		return buffer;
	}

 }
