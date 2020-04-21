package lixuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class Code62KthNode {
    private int index=0;

    /**
     * 方法一
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot!=null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node!=null){
                return node;
            }
            index++;
            if(index==k){
                return pRoot;
            }
            node=KthNode(pRoot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }

    /**
     * 方法二：中序遍历，用list存储结果
     * @param pRoot
     * @param k
     * @return
     */
    private ArrayList<TreeNode> res=new ArrayList<TreeNode>();
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if(pRoot==null){
            return null;
        }
        Inorder(pRoot);
        if(k>=1&&k<=res.size()){
            return res.get(k-1);
        }
        return null;

    }

    private void Inorder(TreeNode pRoot) {
        if(pRoot!=null){
            Inorder(pRoot.left);
            res.add(pRoot);
            Inorder(pRoot.right);
        }
    }

    /**
     * 方法三：中序遍历非递归
     * @param pRoot
     * @param k
     * @return
     */
    private int count=0;
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if(pRoot==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p=pRoot;
        while (!stack.isEmpty()||p!=null){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            count++;
            if(count==k){
                return p;
            }
            p=p.right;

        }
        return null;
    }
}
