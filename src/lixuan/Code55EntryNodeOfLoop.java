package lixuan;

import util.ListNode;

import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Code55EntryNodeOfLoop {
    /**
     * 方法一：利用规律
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null||pHead.next==null){
            return null;
        }
        ListNode slow=pHead;
        ListNode fast=pHead;
        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                ListNode res=pHead;
                while (res!=fast){
                    res=res.next;
                    fast=fast.next;
                }
                return res;
            }
        }
        return null;

    }

    /**
     * 方法二：利用hashmap
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead==null||pHead.next==null){
            return null;
        }
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        ListNode node=pHead;
        while (node!=null){
            if(!hashMap.containsKey(node)){
                hashMap.put(node,0);
            }
            hashMap.put(node,hashMap.get(node)+1);
            if(hashMap.get(node)==2){
                return node;
            }
            node=node.next;
        }
        return null;

    }
}
