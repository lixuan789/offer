package lixuan;

import util.TreeNode;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Code26Convert {
    /**
     * 解题思路：
     * 1.核心是中序遍历的非递归算法。
     * 2.修改当前遍历节点与前一遍历节点的指针指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p=pRootOfTree;
        TreeNode pre=null;//前缀
        boolean isFirst=true;
        TreeNode head=null;
        while (!stack.isEmpty()||p!=null){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if(isFirst){
                head=p;
                pre=p;
                isFirst=false;
            }else {
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            p=p.right;
        }
        return head;

    }

    /**
     * 递归
     * @param pRootOfTree
     * @return
     */
    TreeNode pre =null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        TreeNode pre =null;
        convertHelper(pRootOfTree);
        TreeNode res=pRootOfTree;
        while (res.left!=null){
            res=res.left;
        }
        return res;

    }

    private void convertHelper(TreeNode pRootOfTree) {
        if (pRootOfTree==null)return;
        convertHelper(pRootOfTree.left);

        pRootOfTree.left=pre;
        if(pre!=null)pre.right=pRootOfTree;
        pre=pRootOfTree;

        convertHelper(pRootOfTree.right);
    }
}
