package lixuan;
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Code40FindNumsAppearOnce {
    /**
     * 方法一：哈希算法
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i],0);
            }
            map.put(array[i],map.get(array[i])+1);
        }
        for (int i = 0; i < array.length; i++) {
            if(map.get(array[i])==1){
                num1[0]=array[i];
                break;
            }
        }
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=num1[0]){
                temp^=array[i];
            }
        }
        num2[0]=temp;

    }

    /**经典
     *
     *
     * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     *
     * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，
     * 剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
     * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
     * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int xor=0;
        for (int i = 0; i < array.length; i++) {
            xor^=array[i]; //xor的结果为不同的两个数的异或
        }
        int index=1;//从左往右找到第一个两个数不同的二进制位
        while ((index&xor)==0){
            index<<=1;
        }
        int res1=0;
        int res2=0;
        for (int i = 0; i < array.length; i++) {
            //数组中的两个不同的数分别开来，不会同时取其中一种情况
            if((array[i]&index)==0){
                res1^=array[i];
            }else {
                res2^=array[i];
            }
        }
        num1[0]=res1;
        num2[0]=res2;
    }
}
