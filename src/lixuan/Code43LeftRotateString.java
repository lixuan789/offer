package lixuan;

import java.util.Arrays;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Code43LeftRotateString {
    /**
     * 方法一
     * @param str
     * @param n
     * @return
     */
    public  String LeftRotateString(String str,int n) {
        int len=str.length();
        if(len==0){
            return "";
        }
        n=n%len;
        StringBuilder res = new StringBuilder();
        char[] chars = str.toCharArray();
        reversal(chars,0,len-1);
        reversal(chars,0,len-n-1);
        reversal(chars,len-n,len-1);
        for (char c :chars){
            res.append(c);
        }
        return res.toString();
    }

    private  void reversal(char[] str, int left, int right) {
        for (int i = left,j=right; i < j; i++,j--) {
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
        }
    }

    public static void main(String[] args) {
        Code43LeftRotateString rotateString = new Code43LeftRotateString();
        String str = rotateString.LeftRotateString1("abcXYZdef", 3);
        System.out.println(str);
    }

    /**
     * 方法二：调用API
     * @param str
     * @param n
     * @return
     */
    public  String LeftRotateString1(String str,int n) {
        int len=str.length();
        if(len==0){
            return "";
        }
        n=n%len;
        return str.substring(n)+str.substring(0,n);
    }
}
