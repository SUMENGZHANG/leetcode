/**反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public ListNode reverseListWithDouble(ListNode head) {
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;
        // ListNode left = dummyHead;
        // ListNode right = head;
        // while(head!=null){
        //     head = head.next;
        //     right.next = left;
        //     left = right;
        //     right = head;
           
        // }
        // return dummyHead.next;
        ListNode left = null;
        ListNode right = head;
        ListNode cur = null;
        while(right!=null){
            cur = right.next;
            right.next = left;
            left = right;
            right = cur;
           
        }
        return left;

    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;

    }


    
}
