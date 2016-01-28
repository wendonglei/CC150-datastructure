import java.util.LinkedList;
public class Solution7{
	public static void main(String args[]){
		AnimalQueue shelter = new AnimalQueue();
		shelter.enqueue(new Dog("huanhuan"));
		shelter.enqueue(new Dog("leilei"));
		shelter.enqueue(new Cat("MIMI"));
		shelter.enqueue(new Dog("heizi"));
		shelter.enqueue(new Cat("MIMI"));
		shelter.enqueue(new Cat("MIAO"));
		shelter.enqueue(new Dog("lulu"));
		System.out.println(shelter.dequeueCat().name+" leave");
		System.out.println(shelter.dequeueDog().name+" leave");
		System.out.println(shelter.dequeueAny().name+" leave");
		System.out.println(shelter.dequeueAny().name+" leave");
		System.out.println(shelter.dequeueDog().name+" leave");
		System.out.println(shelter.dequeueAny().name+" leave");
		System.out.println(shelter.dequeueDog().name+" leave");
		//System.out.println(shelter.dequeueCat().name+" leave");
	}
}

class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int totalOrder = 0;

	public void enqueue(Animal a){
		a.setOrder(totalOrder);
		totalOrder++;
		if(a instanceof Dog){
			dogs.offer((Dog)a);
		}else if(a instanceof Cat){
			cats.offer((Cat)a);
		}

		System.out.println(a.name+" join in");
	}

	public Dog dequeueDog(){
		return dogs.poll();
	}
	public Cat dequeueCat(){
		return cats.poll();
	}

	public Animal dequeueAny(){
		if(dogs.isEmpty())
			return cats.poll();
		if(cats.isEmpty())
			return dogs.poll();
		if(dogs.peek().getOrder()<cats.peek().getOrder()){
			return dogs.poll();
		}else{
			return cats.poll();
		}

	}
}

class Animal{
	int order;
	String name;
	public Animal(String a){
		name = a;
	}
	public int getOrder(){
		return order;
	}
	public void setOrder(int order){
		this.order = order;
	}
}

class Dog extends Animal{
	public Dog(String a){
		super(a);
	}
}
class Cat extends Animal{
	public Cat(String a){
		super(a);
	}
}	