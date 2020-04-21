package lixuan;

import util.ListNode;

import java.util.ArrayList;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 */
public class Code46LastRemaining_Solution {
    /**
     * 方法一：利用数组模拟
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m<1){
            return -1;
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        return lastRemaining(array,0,m);

    }

    private int lastRemaining(ArrayList<Integer> array, int s, int m) {
        int n=array.size();
        if(n==1){
            return array.get(0);
        }
        if(n==0){
            return -1;
        }
        int temp=(s+m-1)%n;
        array.remove(temp);
        if(temp==n-1){
            temp=0;
        }
        return lastRemaining(array,temp,m);
    }

    /**
     * 循环链表
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {

        if(m <= 0 || n <= 0){
            return -1;
        }
        //先构造循环链表
        ListNode head = new ListNode(0); //头结点, 值为0
        ListNode pre = head;
        ListNode temp = null;
        for(int i = 1; i < n; i++){
            temp = new ListNode(i);
            pre.next = temp;
            pre = temp;
        }
        temp.next = head;//将第n-1个结点(也就是尾结点)指向头结点

        ListNode temp2 = null;
        while(n != 1){
            temp2 = head;
            //先找到第m个结点的前驱
            for(int i = 1; i < m - 1; i++){
                temp2 = temp2.next;
            }
            //删除第m个结点：将第m个结点的前驱指向第m个结点后面那个结点,temp2表示第m个结点的前驱
            temp2.next = temp2.next.next;
            head = temp2.next; //更新头结点
            n--;
        }

        return head.val;

    }


    /**
     * 递推公式
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution2(int n, int m) {
        //把n看作第几个人，假设第n-1个人的胜利者编号知道了，推出第n个人的编号

        if(n==0){
            return -1;
        }
        if(n==1){
            return 0;
        }
        return (LastRemaining_Solution(n-1,m)+m)%n;

    }
    public static void main(String[] args) {
        Code46LastRemaining_Solution solution = new Code46LastRemaining_Solution();
        int i = solution.LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
}
