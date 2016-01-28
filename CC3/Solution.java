public class Solution {
	static int stackNum= 3;
	static int stackSize=4;
	static int total=12;	//stackSize*stackNum;
	static int size=0;
	static int[] arrayBuffer=new int[total];
	static int[] startPointer={0,stackSize,stackSize*2};
	static int[] endPointer={-1,stackSize-1,stackSize*2-1};

	public static boolean withIn(int a, int b, int c) {
		if(a==b+1)
			return false;
		if(a<=b&&c>=a&&c<=b)
			return true;
		if((a>b&&c>=a)||(a>b&&c<=b))
			return true;

		return false;
	}
	public static void push(int thStack, int value) throws Exception {
		//int pre = startPointer[thStack]==0 ? total-1 : startPointer[thStack]-1;
		int next=(endPointer[thStack]+1)%total;
		//int preStack= thStack==0 ? stackNum-1 : thStack-1;
		int nextStack= (thStack+1)%stackNum;
		if(size==total)
			throw new Exception("out of space");

		if(withIn(startPointer[nextStack], endPointer[nextStack], next)) {
			shift(nextStack);			
		}
		arrayBuffer[next]=value;
		endPointer[thStack]=next;
		size++;			 				
	}
	
	public static void shift(int thStack) {
		int next= (endPointer[thStack]+1)%total;
		int nextStack= (thStack+1)%stackNum;
		//if(startPointer[nextStack]<=next && next<=endPointer[nextStack]) 
		if(withIn(startPointer[nextStack], endPointer[nextStack], next)){
			shift(nextStack);
		}

		/*for(int i=endPointer[thStack];i>=startPointer[thStack];i--){
			arrayBuffer[(i+1)%total]=arrayBuffer[i];
		}*/
		int i=endPointer[thStack];
		while(withIn(startPointer[thStack], endPointer[thStack], i)) {
			arrayBuffer[(i+1)%total]=arrayBuffer[i];
			i--;
			if(i<0)
				i=i+total;
		}
		arrayBuffer[startPointer[thStack]]=0;
		endPointer[thStack]=(endPointer[thStack]+1)%total;
		startPointer[thStack]=(startPointer[thStack]+1)%total;
	}

	public static int pop(int thStack) throws Exception{
		if(startPointer[thStack]==(endPointer[thStack]+1)&&size<total)
			throw new Exception("empty stack");
		int result=arrayBuffer[endPointer[thStack]];
		arrayBuffer[endPointer[thStack]]=0;
		endPointer[thStack]--;
		if(endPointer[thStack]<0)
			endPointer[thStack]=endPointer[thStack]+total;
		size--;
		return result;
	}
    
    public static void main(String args[]) {
    	try {
    		push(0,1);
    		push(1,1);
    		push(2,1);
    		//pop(0);
    		push(1,2);
    		push(1,3);
    		push(1,4);
    		push(1,5);
    		push(1,6);
    		push(1,7);
    		push(1,8);
    		push(1,9);
    		push(1,10);
    		pop(0);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(1);
    		pop(2);
    		int i=0;
    		while(i<arrayBuffer.length){
    			System.out.print(arrayBuffer[i]+", ");
    			i++;
    		}
    	}catch(Exception ex){
    		System.out.println(ex);
    	}

    }

}