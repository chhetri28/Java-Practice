import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        List<Integer> ans= NGEL(arr);
        System.out.println(ans);
    }
    public static List<Integer> NGER(ArrayList<Integer> elemList){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=elemList.size()-1;i>=0;i--){
            //1st condition is if st is empty then add -1
            if(st.size()==0) list.add(-1);
            //2nd condition is to check if stack top element is bigger then curr element
            else if(st.size()>0 && st.peek()>elemList.get(i)) list.add(st.peek());
            //3rd condition remove element from the stack till be get bigger element
            else if(st.size()>0 && st.peek()<elemList.get(i)){
                //remove till you find bigger element in stack
                while(st.size()>= 0 && st.peek()<=elemList.get(i)){
                    st.pop();
                }
                if(st.size()==0)list.add(-1);
                else list.add(st.peek());
            }
            st.add(elemList.get(i));
        }
        Collections.reverse(list);
        return list;
    }
    
    public static List<Integer> NGEL(ArrayList<Integer> elemList) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0;i<elemList.size();i++) {
            // 1st condition is if st is empty then add -1
            if (st.size() == 0)
                list.add(-1);
            // 2nd condition is to check if stack top element is bigger then curr element
            else if (st.size() > 0 && st.peek() > elemList.get(i))
                list.add(st.peek());
            // 3rd condition remove element from the stack till be get bigger element
            else if (st.size() > 0 && st.peek() < elemList.get(i)) {
                // remove till you find bigger element in stack
                while (st.size() >= 0 && st.peek() <= elemList.get(i)) {
                    st.pop();
                }
                if (st.size() == 0)
                    list.add(-1);
                else
                    list.add(st.peek());
            }
            st.add(elemList.get(i));
        }
        return list;
    }
}
