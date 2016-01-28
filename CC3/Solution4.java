import java.util.Stack;
public class Solution4{
	public static void main(String args[]){
		Tower[] game = new Tower[3];
		game[0]=new Tower(5,1);
		game[1]=new Tower(0,2);
		game[2]= new Tower(0,3);

		moveTo(5,game[0],game[2],game[1]);
	}

	public static void moveTo(int index, Tower origin, Tower destination, Tower buffer){
		if(index==1){
			origin.moveaTo(destination);
			return;
		}
			
		moveTo(index-1, origin, buffer, destination);
		moveTo(1,origin,destination,buffer);
		moveTo(index-1,buffer,destination,origin);
	}

}
 class Tower{
 	Stack<Integer> disks;
 	int size;
 	int no;
 	public Tower(int size, int no){
 		disks = new Stack<Integer>();
 		this.size = size;
 		this.no=no;
 		for(int i=size;i>0;i--){
 			disks.push(i);
 		}
 	}

 	public void add(int disk){
 		if(disks.empty()||disks.peek()>disk){
 			disks.push(disk);
 			size++;
 		}else{
 			System.out.println("can not place this disk here");
 		}
 	}

 	public void moveaTo(Tower des){
 		int temp = disks.pop();
 		size--;
 		des.add(temp);
 		System.out.println("move disk"+temp+"to tower"+ des.no);
 	}
 }