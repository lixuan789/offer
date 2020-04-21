package lixuan;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Code42FindNumbersWithSum {
    /**
     * 方法一：双指针
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left=0;
        int right=array.length-1;
        int num1=0,num2=0;
        int min=Integer.MAX_VALUE;
        boolean flag=false;
        ArrayList<Integer> list = new ArrayList<>();
        while (left<right){
            int temp=array[left]+array[right];
            if(temp==sum){
                flag=true;
                int multi=array[left]*array[right];
                if(multi<min){
                    num1=array[left];
                    num2=array[right];
                    min=multi;
                }
                left++;
            }
            if(temp>sum){
                right--;
            }
            if(temp<sum){
                left++;
            }

        }
        if(flag){
            list.add(num1);
            list.add(num2);
        }
        return list;
    }

    /**
     * 方法一优化：若ai + aj == sum，就是答案（相差越远乘积越小）
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        int left=0;
        int right=array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left<right){
            int temp=array[left]+array[right];
            if(temp==sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
            if(temp>sum){
                right--;
            }
            if(temp<sum){
                left++;
            }

        }
        return list;
    }

}
