package lixuan;

import util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList.
 */
public class Code03PrintListFromTailToHead {
    /**
     * 方法一：头插法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null){
            return null;
        }
        ListNode head=listNode;
        ListNode dummy = new ListNode(0);//哑元
        dummy.next=null;
        while (head!=null){
            ListNode node = head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=node;
        }
        ListNode p = dummy.next;
        ArrayList<Integer> result = new ArrayList<>();
        while (p!=null){
            result.add(p.val);
            p=p.next;
        }
        return result;
    }

    /**
     * 利用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        if (listNode==null){
            return result;
        }
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            Integer num = stack.pop();
            result.add(num);
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();

        if (listNode==null){
            return result;
        }
        while (listNode!=null){
            result.add(0,listNode.val);
            listNode=listNode.next;
        }

        return result;
    }

    /**
     * 使用递归
     * @param listNode
     * @return
     */
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead3(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

}
