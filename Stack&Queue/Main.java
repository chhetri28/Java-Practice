import java.util.*;
/*class CustomStack{
  protected int[] data;
  private static final int default_size=10;
  int indx=-1;
  
  public CustomStack(){
    this(default_size);
  }
  public CustomStack(int size){
    this.data=new int[size];
  }
  public boolean push(int item){
    if(isFull()){
      System.out.println("Stack is full");
      return false;
    }
    indx++;
    data[indx]=item;
    return true;
  }
  public int pop(){
    if(isEmpty()){
      System.out.print("Cannot pop from an empty stack!!");
    }
    int removed=data[indx];
    indx--;
    return removed;
  }
  public int peek(){
    if(isEmpty()){
      System.out.print("Cannot peek from an empty stack!!");
    }
    return data[indx];
  }
  public boolean isFull(){
    return indx==data.length -1;
  }
  public boolean isEmpty(){
    return indx==-1;
  }
}

class DynamicStack extends CustomStack{
  public DynamicStack(){
    super();
  }
  public DynamicStack(int size){
    super(size);
  }
  public boolean push(int item){
    if(this.isFull()){
      //double the array size
      int [] temp= new int[data.length *2];

      //copy the previous element 
      for(int i=0;i<data.length;i++){
        temp[i]=data[i];
      }
      data=temp;
    }
    return super.push(item);
  }
}
*/

class CustomQueue{
  private int[] data;
  private static final int default_size=10;
  int end=0;
  public CustomQueue(){
    this(default_size);
  }
  public CustomQueue(int size){
    this.data=new int[size];
  }
  public boolean isFull(){
    return end==data.length;
  }
  public boolean isEmpty(){
    return end==0;
  }
  public boolean add(int item){
    if(isFull()){
      return false;
    }
    data[end++] = item;
    return true;
  }
  public int remove(){
    if(isEmpty()){
      System.out.println("Queue is empty");
    }
    int removed=data[0];
    //shift the element
    for(int i=1;i<end;i++){
      data[i-1]=data[i];
    }
    end--;
    return removed;
  }
  public int peek(){
    if(isEmpty()){
      System.out.println("Queue is empty");
    }
    return data[0];
  }
  public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

}
class Main {
  public static void main(String[] args) {
    CustomQueue q=new CustomQueue(5);
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    /*System.out.println("Hello world!");
    DynamicStack stack =new DynamicStack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    System.out.println( stack.pop());
    System.out.println( stack.pop());
    System.out.println( stack.pop());
    System.out.println( stack.pop());
    System.out.println( stack.pop());
*/
    /*Stack<Integer> stack= new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println( stack);
    System.out.println( stack.pop());
    */
    /*Queue<Integer> q=new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    System.out.println(q.remove());*/
    
  }
}