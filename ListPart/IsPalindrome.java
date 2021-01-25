/**
 * 回文链表
 */
public class IsPalindrome {
    /**
     * 我的思路
     * 1. 求长度
     * 2. 对半分
     * 3. 前一半反转
     * 4. 判断是否相同
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode newOne= head; 
        while(newOne!=null){
            newOne = newOne.next;
            len++;
        }
        
        int numWeNeed = len/2;
        // 取到后一半
        ListNode back = head;
        while(numWeNeed>0){
            back = back.next;
            numWeNeed--;
        }
        ListNode backReverse = reverse(back);
        
        // 判断
        int count  = len%2==0?len/2:len/2+1;
        ListNode front  = head;
        while(count>0){
            if(front.val!=backReverse.val){
                return false;
            }
            else{
                front = front.next;
               backReverse = backReverse.next;

            }
            count--;
        }
        
        return true;
    }
    public static ListNode reverse(ListNode head){
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
     
    
}
