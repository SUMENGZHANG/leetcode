import javax.swing.text.DefaultStyledDocument.ElementSpec;

/**
 * 
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode head = null;
        newHead.next = head;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                head = l1;
                l1 = l1.next;
            }else{
                head = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head = l1==null?l2:l1;
        return newHead.next;

    }
    
}
