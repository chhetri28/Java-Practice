import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Pair {
    int First;
    int Second;

    public Pair(int first, int second) {
        First = first;
        Second = second;
    }

}

public class StackProblems {
    public static void main(String[] args) {

        // ArrayList<Integer> arr=new ArrayList<>();
        // arr.add(89);
        // arr.add(62);
        // arr.add(70);
        // arr.add(58);
        // arr.add(47);
        // arr.add(47);
        // arr.add(46);
        // arr.add(76);
        // arr.add(100);
        // arr.add(70);
        // List<Integer> ans= NGER(arr);
        // System.out.println(ans);

        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        ArrayList<Integer> res = calculateSpan2(price);
        // int temp[]={73,74,75,71,69,72,76,73};
        // ArrayList<Integer> res=dailyTemperatures(temp);
        System.out.println(res);
    }

    public static List<Integer> NGER(ArrayList<Integer> elemList) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = elemList.size() - 1; i >= 0; i--) {
            // 1st condition is if st is empty then add -1
            if (st.size() == 0)
                list.add(-1);
            // 2nd condition is to check if stack top element is bigger then curr element
            else if (st.size() > 0 && st.peek() > elemList.get(i))
                list.add(st.peek());
            // 3rd condition remove element from the stack till be get bigger element
            else if (st.size() > 0 && st.peek() < elemList.get(i)) {
                // remove till you find bigger element in stack
                while (st.size() > 0 && st.peek() <= elemList.get(i)) {
                    st.pop();
                }
                if (st.size() == 0)
                    list.add(-1);
                else
                    list.add(st.peek());
            }
            st.add(elemList.get(i));
        }
        Collections.reverse(list);
        return list;
    }

    public static List<Integer> NGEL(ArrayList<Integer> elemList) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < elemList.size(); i++) {
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

    public static List<Integer> NSEL(ArrayList<Integer> elemList) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < elemList.size(); i++) {
            // 1st condition is if st is empty then add -1
            if (st.size() == 0)
                list.add(-1);
            // 2nd condition is to check if stack top element is smaller then curr element
            else if (st.size() > 0 && st.peek() < elemList.get(i))
                list.add(st.peek());
            // 3rd condition remove element from the stack till be get smaller element
            else if (st.size() > 0 && st.peek() >= elemList.get(i)) {
                // remove till you find bigger element in stack
                while (st.size() >= 0 && st.peek() >= elemList.get(i)) {
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

    public static List<Integer> NSER(ArrayList<Integer> elemList) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = elemList.size() - 1; i >= 0; i--) {
            // 1st condition is if st is empty then add -1
            if (st.size() == 0)
                list.add(-1);
            // 2nd condition is to check if stack top element is smaller then curr element
            else if (st.size() > 0 && st.peek() < elemList.get(i))
                list.add(st.peek());
            // 3rd condition remove element from the stack till be get smaller element
            else if (st.size() > 0 && st.peek() >= elemList.get(i)) {
                // remove till you find bigger element in stack
                while (st.size() > 0 && st.peek() >= elemList.get(i)) {
                    st.pop();
                }
                if (st.size() == 0)
                    list.add(-1);
                else
                    list.add(st.peek());
            }
            st.add(elemList.get(i));
        }
        Collections.reverse(list);
        return list;
    }

    public static ArrayList<Integer> calculateSpan(int arr[]) {
        ArrayList<Integer> l = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                l.add(-1);
            } else if (st.size() > 0 && st.peek().First > arr[i]) {
                l.add(st.peek().Second);
            } else if (st.size() > 0 && st.peek().First <= arr[i]) {
                while (st.size() > 0 && st.peek().First <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0)
                    l.add(-1);
                else
                    l.add(st.peek().Second);
            }
            st.push(new Pair(arr[i], i));
        }
        for (int i = 0; i < l.size(); i++) {
            int ele = i - l.get(i);
            l.set(i, ele);
        }
        return l;
    }

    public static ArrayList<Integer> calculateSpan2(int arr[]) {
        ArrayList<Integer> l = new ArrayList<>();
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                l.add(-1);
            } else if (st.size() > 0 && st.peek()[0] > arr[i]) {
                l.add(st.peek()[1]);
            } else if (st.size() > 0 && st.peek()[0] <= arr[i]) {
                while (st.size() > 0 && st.peek()[0] <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0)
                    l.add(-1);
                else
                    l.add(st.peek()[1]);
            }
            st.push(new int[] { arr[i], i });
        }
        for (int i = 0; i < l.size(); i++) {
            int ele = i - l.get(i);
            l.set(i, ele);
        }
        return l;
    }

    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.size() == 0)
                list.add(0);
            else {
                list.add(st.peek() - i);
            }
            st.add(i);
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static ArrayList<Integer> NSERI(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = arr.size();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr.get(st.peek()) >= arr.get(i)) {
                st.pop();
            }
            if (st.size() == 0)
                list.add(n);
            else {
                list.add(st.peek());
            }
            st.add(i);
        }
        Collections.reverse(list);
        return list;
    }

    public static ArrayList<Integer> NSELI(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && arr.get(st.peek()) >= arr.get(i)) {
                st.pop();
            }
            if (st.size() == 0)
                list.add(-1);
            else {
                list.add(st.peek());
            }
            st.add(i);
        }
        return list;
    }

    public static int largestRectangleArea(int[] heights) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            arr.add(heights[i]);
        }
        ArrayList<Integer> right = NSERI(arr);
        ArrayList<Integer> left = NSELI(arr);
        int ans = -1;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, (right.get(i) - left.get(i) - 1) * heights[i]);
        }
        return ans;
    }

}

/*
 * 
 * Summary:
 * 
 * Problem Stack Type Operator in while loop
 * next greater right decreasing stackTop <= current
 * previous greater decreasing stackTop <= current
 * next smaller increasing stackTop >= current
 * previous smaller increasing stackTop >= current
 */