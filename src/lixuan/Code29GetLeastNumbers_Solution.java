package lixuan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class Code29GetLeastNumbers_Solution {
    /**
     * 最大堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length||k==0){
            return result;
        }
        //最大堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size()<=k){
                priorityQueue.add(input[i]);
            }else {
                if (priorityQueue.peek()>input[i]){
                    priorityQueue.poll();
                    priorityQueue.add(input[i]);
                }
            }
        }
        result.addAll(priorityQueue);
        return result;

    }
}
