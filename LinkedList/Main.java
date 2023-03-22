package LinkedList;

public class Main {
    public static void main(String[] args) {
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;


        ListNode curr=head;
        ListNode prev=null;
        ListNode forw=null;

        while(curr!=null){
            forw=curr.next;//backup
            curr.next=prev;//link
            prev=curr;
            curr=forw;
        }
        return prev;
    }
}
