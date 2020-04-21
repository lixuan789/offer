package lixuan;

import util.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Code17HasSubtree {

    /**
     * 递归
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return judgeSubTree(root1, root2) || judgeSubTree(root1.left, root2) || judgeSubTree(root1.right, root2);
    }

    private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) { //子结构已经循环完毕，代表全部匹配
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return judgeSubTree(root1.left, root2) || judgeSubTree(root1.right, root2);
        }
        return judgeSubTree(root1.left, root2.left) && judgeSubTree(root1.right, root2.right);
    }
}
