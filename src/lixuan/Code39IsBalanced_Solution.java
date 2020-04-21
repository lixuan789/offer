package lixuan;

import util.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Code39IsBalanced_Solution {
    /**
     * 递归
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);

    }

    private int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }
//--------------------

    /**
     * 方法二：优化进行减枝
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        return depth1(root)!=-1;
    }
    private int depth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int a=depth1(root.left);
        if(a==-1)return -1;  //-1代表不是
        int b=depth1(root.right);
        if(b==-1)return -1;
        if(Math.abs(a-b)>1)return -1;
        return Math.max(depth1(root.left),depth1(root.right))+1;
    }
}
