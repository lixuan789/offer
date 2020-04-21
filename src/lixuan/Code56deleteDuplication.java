package lixuan;

import util.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Code56deleteDuplication {
    /**
     * 方法：利用栈和头插法
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {

        if(pHead==null){
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p=pHead;
        stack.push(p);
        p=p.next;
        while (p!=null){
            int num;
            if(stack.isEmpty()){
                num=0;
            }else {
                num=stack.peek().val;
            }
            if(p.val==num){
                while (p.next!=null&&p.next.val==num){
                    p=p.next;
                }
                stack.pop();
            }else {
                stack.push(p);
            }
            p=p.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=null;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }

    /**
     * 双指针
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;

    }
}
