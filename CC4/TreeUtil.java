import java.util.LinkedList;
import java.util.Stack;
public class TreeUtil{
 	public static void main(String args[]) {
 		//TreeUtil test = new TreeUtil();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        //root.left.left = new TreeNode(11);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.right.left.right = new TreeNode(7);
        //levelOrder(root);
 		//System.out.println(toString(root));
 		postOrder2(root);
    }


	public static TreeNode reconstruct(int[] preOrder, int[] inOrder){
		return builtTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}

	public static TreeNode builtTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
		if(preStart>preEnd||inStart>inEnd)
			return null;
		TreeNode root = new TreeNode(preOrder[preStart]);
		int i;
		for(i=inStart; i<=inEnd; i++){
			if(inOrder[i]==preOrder[preStart])
				break;
		}
		root.left=builtTree(preOrder,preStart+1,preStart+(i-inStart),inOrder,inStart,i-1);
		root.right= builtTree(preOrder,preEnd-(inEnd-i)+1,preEnd,inOrder,i+1,inEnd);
		return root;
	}

	public static String toString(TreeNode a){
		LinkedList<TreeNode> treeQueue = new LinkedList<TreeNode>();
		int curLevel=1;
		int nextLevel=0;
		if(a==null)	return "Empty tree";

		StringBuilder str = new StringBuilder();
		TreeNode temp=a;

		while(temp!=null){
			
			str.append(temp.val+"");
			curLevel--;

			if(temp.left!=null){
				treeQueue.offer(temp.left);
				nextLevel++;
			}
				
			if(temp.right!=null){
				treeQueue.offer(temp.right);
				nextLevel++;
			}

			if(curLevel==0){
				curLevel=nextLevel;
				nextLevel=0;
				str.append("\n");
			}			
			temp= treeQueue.poll();
							
		}
		return str.toString();		
	}

	public static void levelOrder(TreeNode temp){
		LinkedList<TreeNode> treeQueue = new LinkedList<TreeNode>();
		while(temp!=null){
			System.out.print(temp.val+" ");
			if(temp.left!=null)
				treeQueue.offer(temp.left);
			if(temp.right!=null)
				treeQueue.offer(temp.right);
			temp=treeQueue.poll();				
		}
	}
	public static void inOrder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp;
		stack.push(root);
		while(!stack.empty()){
			if(stack.peek().left!=null&&(!stack.peek().visited)){
				stack.peek().visited=true;
				stack.push(stack.peek().left);				
			}else{
				temp=stack.pop();
				System.out.print(temp.val+" ");
				if(temp.right!=null){
					stack.push(temp.right);
				}					
			}
		}
	}

	public static void inOrder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur=root; 
		while(true){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;			
			}else{
				if(stack.empty())
					break;
				cur=stack.pop();
				System.out.print(cur.val+" ");
				cur=cur.right;					
			}
		}
	}
	public static void inOrder3(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur=root; 
		while(!stack.empty()||cur!=null){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;			
			}else{
				//if(stack.empty())
				//	break;
				cur=stack.pop();
				System.out.print(cur.val+" ");
				cur=cur.right;					
			}
		}
	}	

	public static void preOrder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur=root; 
		while(!stack.empty()||cur!=null){
			if(cur!=null){
				System.out.print(cur.val+" ");
				stack.push(cur);
				cur=cur.left;			
			}else{
				//if(stack.empty())
					//break;
				cur=stack.pop();
				cur=cur.right;					
			}
		}
	}

	public static void postOrder(TreeNode root){
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode cur=root;
		if(cur!=null)
		stack1.push(cur);
		while(!stack1.empty()){
			cur=stack1.pop();
			stack2.push(cur);
			if(cur.left!=null)
				stack1.push(cur.left);
			if(cur.right!=null)
				stack1.push(cur.right);
		}
		while(!stack2.empty()){
			System.out.print(stack2.pop().val+" ");
		}
	}

	public static void postOrder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur=root; 
		TreeNode pre=null; 
		while(!stack.empty()||cur!=null){
			if(cur==null){
				if(stack.peek().right==pre||stack.peek().right==null){
					cur=stack.pop();
					System.out.print(cur.val+" ");
					pre=cur;
					cur=null;
				}else{
					cur=stack.peek();
					cur=cur.right;

				}
			}else{
				stack.push(cur);
				cur=cur.left;
			}
		}
	}

}
class TreeNode {
      public int val;
      public TreeNode left, right;
      public boolean visited;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}

/*void in_order_traversal_iterative(BinaryTree *root) {
  stack<BinaryTree*> s;
  s.push(root);
  while (!s.empty()) {
    BinaryTree *top = s.top();
    if (top != NULL) {
      if (!top->visited) {
        s.push(top->left);
      } else {
        cout << top->data << " ";
        s.pop();
        s.push(top->right);
      }
    } else {
      s.pop();
      if (!s.empty())
        s.top()->visited = true;
    }
  }
}*/