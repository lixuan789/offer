package lixuan;

import util.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，
 * 所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Code36FindFirstCommonNode {
    /**
     * 方法一：简单模拟
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1=0;
        int len2=0;
        ListNode p1=pHead1;
        while (p1!=null){
            len1++;
            p1=p1.next;
        }
        ListNode p2=pHead2;
        while (p2!=null){
            len2++;
            p2=p2.next;
        }
        if(len1>len2){
            for (int i=0;i<len1-len2;i++){
                pHead1=pHead1.next;
            }
        }else {
            for (int i=0;i<len2-len1;i++){
                pHead2=pHead2.next;
            }
        }
        while (pHead1!=null&&pHead2!=null){
            if(pHead1==pHead2){
                return pHead1;
            }
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46?answerType=1&f=discussion
     * 来源：牛客网
     *
     * p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
     * p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
            if(p1!=p2){
                if(p1==null){
                    p1=pHead2;
                }
                if(p2==null){
                    p2=pHead1;
                }
            }
        }
        return p1;

    }
}
