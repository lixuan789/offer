package lixuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Code57isSymmetrical {
    /**
     * 中序遍历的结果为对称
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        TreeNode p=pRoot;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        while (p!=null||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            list.add(p);
            p=p.right;
        }
        for (int i=0,j=list.size()-1;i<j;i++,j--){
            if(list.get(i).val!=list.get(j).val){
                return false;
            }
        }
        return true;

    }

//    链接：https://www.nowcoder.com/questionTerminal/ff05d44dfdb04e1d83bdbdab320efbcb?answerType=1&f=discussion
//    来源：牛客网


    /**
     * 方法二：递归
     * @param node1
     * @param node2
     * @return
     */
    public boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    public boolean isSymmetrical2(TreeNode pRoot) {
        return pRoot==null || jude(pRoot.left, pRoot.right);
    }


    /**
     * 层序遍历
     * @param pRoot
     * @return
     */
    boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode left= s.poll();//成对取出
            TreeNode right= s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
}
