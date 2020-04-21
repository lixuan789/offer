package lixuan;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class Code20Stack {
    //方法一：同步栈的方法
    /*Stack<Integer> stack1= new Stack<Integer>();
    Stack<Integer> stack2= new Stack<Integer>();//同步栈
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()||stack2.peek()>node){
            stack2.push(node);
        }else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }*/

    //方法二：辅助变量
    Stack<Integer> stack= new Stack<Integer>();
    int min,top;
    public void push(int node) {
        if(stack.isEmpty()){
            min=node;
        }
        stack.push(node-min);
        if(node<min){
            min=node;
        }
        top=node;

    }

    public void pop() {
        if(!stack.isEmpty()){
            if(stack.peek()<0){
                min-=stack.peek();
            }
            stack.pop();
            if(!stack.isEmpty()){
                if (stack.peek()>0){
                    top=min+stack.peek();
                }else {
                    top=min;
                }
            }
        }

    }

    public int top() {
        return top;

    }

    public int min() {
        return min;
    }

}
