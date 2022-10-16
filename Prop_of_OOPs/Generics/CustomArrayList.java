
import java.util.Arrays;

class CustomArrayList<T>{
    private int[] data;
    private static int default_size = 10;
    private int size = 0;

    public CustomArrayList() {
        data=new int[default_size];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize(){
        int[] temp = new int[data.length * 2];

        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size == data.length;
    }
    public int remove(){
        int removed=data[size--];
        return removed;
    }
    public int size(){
        return size;
    }
    public int get(int index){
        return data[index];
    }
    public void set(int index,int value){
        data[index]=value;
    }
    @Override
    public String toString() {
        return "CustomArrayList{"+
        "data=" + Arrays.toString(data) +", size="+ size+ "}";
    }
    public static void main(String[] args) {
        CustomArrayList list=new CustomArrayList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list);

    }
}
