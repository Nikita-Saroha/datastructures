package ds.java.stack;

public class StackByArray {
	
	static final int MAX = 1000;
	int stack[] = new int[MAX];
	int top;
	
	public StackByArray(){
		top = -1;
	}
	
	public boolean isEmpty(){
		return top < 0;
	}
	
	public boolean push(int x){
		if(top > MAX){
			System.out.println("Stack Overflow");
			return false;
		}else{
			stack[++top] = x;
			return true;
		}
	}
	
	public int pop(){
		if(top < 0){
			System.out.println("Stack overflow");
			return 0;
		}else{
			int x = stack[top--];
			return x;
		}
	}
	
	public void print(){
		System.out.print("[");
		for(int i=0; i <= top; i++){
			System.out.print(stack[i]);
			if(i != top)
				System.out.print(", ");
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		StackByArray stackByArray = new StackByArray();
		stackByArray.push(1);
		stackByArray.push(2);
		stackByArray.push(3);
		stackByArray.push(4);
		stackByArray.pop();
		stackByArray.push(5);
		stackByArray.print();
		
	}

}
