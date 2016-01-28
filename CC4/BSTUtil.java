
public class BSTUtil{
	public static int index=0;
	public static BSTNode reconstructPre(int[] preOrder, int lo, int hi){
		if(lo>hi) return null;
		int index=0;
		BSTNode root = new BSTNode(preOrder[lo]);
		for(int i=lo+1; i<=hi;i++){
			if(preOrder[i]>preOrder[lo]){
				index=i;
				break;
			}
				
		}
		if(index==0)
			index=hi+1;
		root.left=reconstructPre(preOrder,lo+1,index-1);
		root.right=reconstructPre(preOrder,index,hi);
		return root;
	}
	public static BSTNode reconstructPre2(int[] preOrder, int min, int max){
		if(index>=preOrder.length)	return null;
		int value = preOrder[index];
		BSTNode root=null;
		if(value>min&&value<max){
			root = new BSTNode(value);
			index++;
			System.out.println("index"+index);
			root.left=reconstructPre2(preOrder,min,value);
			root.right= reconstructPre2(preOrder,value,max);

		}

		return root;
			
	}

	public static BSTNode reconNonrecursive(int[] preOrder){
				
	}
	public static void printInorder(BSTNode node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
        //BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 5, 1, 7, 6,40, 50};
        //BSTNode root = reconstructPre(pre, 0, pre.length-1);
        BSTNode root = reconstructPre2(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Inorder traversal of the constructed tree is ");
        printInorder(root);
    }
}
class BSTNode {
 
    int data;
    BSTNode left, right;
 
    BSTNode(int d) {
        data = d;
        left = right = null;
    }
}