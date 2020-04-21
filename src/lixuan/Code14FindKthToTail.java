package lixuan;

import util.ListNode;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Code14FindKthToTail {
    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null||k<0){
            return null;
        }
        int len=0;
        ListNode temp=head;
        while (temp!=null){
            len++;
            temp=temp.next;
        }
        if(k>len){
            return null;
        }
        ListNode p=head;
        while (k>0){
            k--;
            p=p.next;
        }
        ListNode q=head;
        while (p!=null){
            p=p.next;
            q=q.next;
        }
        return q;
    }

    /**
     * 优化
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        if(head==null||k<0){
            return null;
        }
        ListNode slow,fast;
        slow=fast=head;
        int len=0;
        for (;fast!=null;len++){
            if(len>=k){
                slow=slow.next;
            }
            fast=fast.next;
        }
        return len<k?null:slow;
    }
}
