package lixuan;

import util.ListNode;

/**
 *输入一个链表，反转链表后，输出新链表的表头。
 */
public class Code15ReverseList {
    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);//哑元
        dummy.next=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        return dummy.next;
    }

    /**
     * 指针反转
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


}
