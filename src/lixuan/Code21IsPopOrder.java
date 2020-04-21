package lixuan;

import java.util.Stack;

public class Code21IsPopOrder {
    /**
     * 方法一：出栈的每个数之前入栈的数必须倒序
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        if (popA.length==1){
            return pushA[0]==popA[0];
        }
        for (int i=0;i<popA.length-1;i++){
            int num=popA[i];
            for (int j=0;j<pushA.length;j++){
                if(pushA[j]==num){
                    break;
                }
                boolean flag=true;
                for (int k=0;k<=i;k++){
                    if (pushA[j]==popA[k]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    stack.push(pushA[j]);
                }
            }

            for (int k=i+1;k<popA.length;k++){
                if(!stack.isEmpty()&&popA[k]==stack.peek()){
                    stack.pop();
                }
            }
            if(!stack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    /**
     * 模拟出栈
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        if (pushA.length==0||pushA.length!=popA.length){
            return false;
        }
        int j=0;//出栈序列的索引
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int [] pushA={1,2,3,4,5};
        int [] popA={3,5,4,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
