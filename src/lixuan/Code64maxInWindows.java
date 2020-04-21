package lixuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Code64maxInWindows {
    /**
     * 方法一：方法窗口+最大堆
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int start = 0;
        int end = start + size - 1;
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        while (end < num.length) {
            for (int i = start; i <= end; i++) {
                maxHeap.add(num[i]);
            }
            Integer maxNum = maxHeap.poll();
            res.add(maxNum);
            start++;
            end++;
            maxHeap.clear();
        }
        return res;
    }

    /**
     * 方法二：类似方法一
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {

        int start = 0;
        int end = start + size - 1;
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return res;
        }
        while (end < num.length) {
            int maxNum = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (num[i] > maxNum) {
                    maxNum = num[i];
                }
            }
            res.add(maxNum);
            start++;
            end++;
        }
        return res;
    }

    /**
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1.判断当前最大值是否过期
     * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);

            } else if (begin > deque.peekFirst()) {//不在滑动窗口内了
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {//窗口内比当前值小的可以直接去除
                deque.pollLast();
            }
            deque.add(i);
            if (begin >= 0) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Code64maxInWindows code64maxInWindows = new Code64maxInWindows();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> list = code64maxInWindows.maxInWindows(num, 3);
        System.out.println(list);
    }

}
