/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 常用技巧，添加哑结点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = head;
        int count = 0;
        while(fast!=null){
            fast = fast.next;
            if(count>=n) slow = slow.next;
            count++;
        }
        slow.next = slow.next.next;
        return newHead.next;
        
    }
      
    public static void main(String[] args) {

        
    }
    
}
