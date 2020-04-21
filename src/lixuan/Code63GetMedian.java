package lixuan;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Code63GetMedian {
    private ArrayList<Integer> list=new ArrayList<Integer>();
    private Set<Integer> temp=new HashSet<Integer>();//避免重复

    /**
     * 方法一：利用快速排序的partition每次可以固定一个位置
     * 使用快速排序算法来实现，其中partition每次调用可以确定一个元素的位置，
     * 所以当位置相符时直接返回，需要注意的是当长度为偶数时，需要存放2个数，为了避免重复，使用set集合存储起来。
     * @param num
     */
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        int len=list.size();
        Integer[] array=new Integer[len];
        for (int i = 0; i < list.size(); i++) {
            array[i]=list.get(i);
        }
        temp.clear();
        Quicksort(array,0,len-1);
        int sum=0;
        for (Integer num : temp) {
            sum+=num;
        }
        return Double.valueOf(len%2==0?sum/2.0:sum);
    }

    private void Quicksort(Integer[] array,int low,int high) {
        int len=array.length;
        if(low<=high){
            int index=Partition(array,low,high);
            if(len%2==0){
                if(index==len/2||index==len/2-1){
                    temp.add(array[index]);
                    if(temp.size()==2){
                        return;
                    }
                }
            }else if(index==len/2){
                temp.add(array[index]);
                return;
            }
            Quicksort(array,low,index-1);
            Quicksort(array,index+1,high);
        }
    }

    private int Partition(Integer[] array, int low, int high) {
        int temp=array[low];
        while (low<high){
            while (low<high&&array[high]>temp){
                high--;
            }
            array[low]=array[high];
            while (low<high&&array[low]<temp){
                low++;
            }
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }




        //小顶堆
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //大顶堆
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //记录偶数个还是奇数个
        int count = 0;
        //每次插入小顶堆的是当前大顶堆中最大的数
        //每次插入大顶堆的是当前小顶堆中最小的数
        //这样保证小顶堆中的数永远大于等于大顶堆中的数
        //中位数就可以方便地从两者的根结点中获取了
        public void Insert1(Integer num) {
            //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
            if(count % 2 == 0){
                maxHeap.offer(num);
                int max = maxHeap.poll();
                minHeap.offer(max);
            }else{
                //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
                minHeap.offer(num);
                int min = minHeap.poll();
                maxHeap.offer(min);
            }
            count++;
        }
        public Double GetMedian1() {
            //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
            if(count % 2 == 0){
                return new Double(minHeap.peek() + maxHeap.peek())/2;
            }else{
                //当前为奇数个，则直接从小顶堆中取元素即可
                return new Double(minHeap.peek());
            }
        }

}
