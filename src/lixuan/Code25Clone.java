package lixuan;

import util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Code25Clone {
    /**
     * 方法一：使用map存储新老节点的映射关系
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode p = pHead;
        RandomListNode q = null;
        RandomListNode newHead = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            if (newHead == null) {
                newHead = new RandomListNode(pHead.label);
                q = newHead;
                map.put(pHead, newHead);
            } else {
                if (p.next != null && map.containsKey(p.next)) {
                    q.next = map.get(p.next);
                } else {
                    if (p.next != null) {
                        RandomListNode temp = new RandomListNode(p.next.label);
                        map.put(p.next, temp);
                        q.next = temp;
                    }
                }
                if (p.random != null && map.containsKey(p.random)) {
                    q.random = map.get(p.random);
                } else {
                    if (p.random != null) {
                        RandomListNode temp = new RandomListNode(p.random.label);
                        map.put(p.random, temp);
                        q.random = temp;
                    }
                }
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 解题思路：
     * *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     * *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     * *3、拆分链表，将链表拆分为原链表和复制后的链表
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

}
