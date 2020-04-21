package lixuan;

import util.TreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Code04ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int n=pre.length;
        return reConstructBinaryTree(0,n-1,0,n-1,pre,in);
    }

    /**
     *
     * @param pres 前序序列开始
     * @param prel 前序序列结束
     * @param ins  后序序列开始
     * @param inl  后序序列结束
     * @param pre  前序序列
     * @param in   后序序列
     * @return
     */
    private TreeNode reConstructBinaryTree(int pres, int prel, int ins, int inl, int[] pre, int[] in) {
        if(pres>prel || ins>inl){
            return null;
        }
        int num=pre[pres];
        TreeNode root = new TreeNode(num);
        int len=0;
        for (int i=ins;i<=inl;i++){
            if(in[i]==num){
                break;
            }
            len++;
        }
        root.left=reConstructBinaryTree(pres+1,pres+len,ins,ins+len-1,pre,in);
        root.right=reConstructBinaryTree(pres+len+1,prel,ins+len+1,inl,pre,in);
        return root;
    }

    /**
     * 方法二
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int [] pre, int [] in) {
        if(pre==null||in==null){
            return null;
        }

        int num=pre[0];
        TreeNode root = new TreeNode(num);
        for (int i = 0; i < in.length; i++) {
            if(in[i]==num){
                root.left=reConstructBinaryTree1(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree1(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }

        return root;
    }
}
