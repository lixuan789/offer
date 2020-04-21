package lixuan;

import util.TreeLinkNode;

import java.util.ArrayList;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Code58TreeLinkNode {
    private ArrayList<TreeLinkNode> list = new ArrayList<>();

    /**
     * 方法一：先找根节点，再中序遍历，用一个list存起来
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        TreeLinkNode parent = pNode;
        while (parent.next != null) {
            parent = parent.next;
        }
        Inorder(parent);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pNode) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;

    }

    private void Inorder(TreeLinkNode root) {
        if (root != null) {
            Inorder(root.left);
            list.add(root);
            Inorder(root.right);
        }
    }

    /**
     * 方法二
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        if (pNode.right != null) {//第一种情况：右孩子不为空
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            if (pNode.next != null && pNode == pNode.next.left) {//情况二：右孩子为空，且是父亲节点的左孩子
                return pNode.next;
            }
            if (pNode.next != null && pNode == pNode.next.right) {//情况三：右孩子为空，且是父亲节点的右孩子
                while (pNode.next != null && pNode == pNode.next.right) {
                    pNode = pNode.next;
                }
                return pNode.next;
            }
        }
        return null;
    }

    /**
     * 优化：情况二和情况三合并
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode.right != null) {//第一种情况：右孩子不为空
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {//情况二：孩子为空
            TreeLinkNode pre = pNode;
            TreeLinkNode cur = pNode.next;
            while (cur != null && cur.right == pre) {
                pre = cur;
                cur = cur.next;
            }
            return cur;
        }
    }
}
