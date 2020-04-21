package lixuan;

import util.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Code16Merge {
    /**
     * 简单的模拟
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        if (list1!=null){
            cur.next=list1;
        }
        if (list2!=null){
            cur.next=list2;
        }
        return dummy.next;
    }

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1==null)return list2;
        if (list2==null)return list1;
        if(list1.val<list2.val){
            list1.next=Merge1(list1.next,list2);
            return list1;
        }else{
            list2.next=Merge1(list1,list2.next);
            return list2;
        }
    }
}
