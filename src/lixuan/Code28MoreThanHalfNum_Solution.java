package lixuan;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Code28MoreThanHalfNum_Solution {
    /**
     * 方法一
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int cnt=1;
        int num=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]!=num){
                cnt--;
            }else {
                cnt++;
            }
            if(cnt==0){
                num=array[i];
                cnt=1;
            }
        }
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==num){
                temp++;
            }
        }
        return temp>array.length/2?num:0;
    }

    /**
     * 方法二
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        Arrays.sort(array);
        int i=array[array.length/2];
        return IntStream.of(array).filter(k->k==i).count()>array.length/2?i:0;
    }
}
