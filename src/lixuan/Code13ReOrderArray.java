package lixuan;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Code13ReOrderArray {
    /**
     * 双指针:不能原始的顺序
     * @param array
     */
    public void reOrderArray(int [] array) {
        int cur=0;//当前元素
        int n=array.length;
        int i=-1;//奇数区域的尾指针
        while (cur<n){
            if(array[cur]%2==1){
                i++;
                int temp=array[cur];
                array[cur]=array[i];
                array[i]=temp;
            }
            cur++;
        }
    }

    public static void reOrderArray1(int [] array) {
        int evens[]=new int[array.length];
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                evens[j++]=array[i];
            }
        }
        int pos=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                array[pos++]=array[i];
            }
        }
        for (int i=pos;i<array.length;i++){
            array[i]=evens[i-pos];
        }
    }

    /**
     * 双指针：每次交换第一次遇到的偶数和奇数
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        if(array.length<=1){
            return;
        }//长度为1的情况排除
        int i=0;
        while (i<array.length){
            int j=i+1;
            if(array[i]%2==0){
                while (array[j]%2==0){
                    if(j==array.length-1){
                        return;
                    }
                    j++;
                }
                int count=j-i;
                int temp=array[i];
                array[i]=array[j];
                while (count>1){
                    array[i+count]=array[i+count-1];
                    count--;
                }
                array[i+1]=temp;
            }
            i++;//为奇数直接往后遍历
        }
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        reOrderArray1(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
