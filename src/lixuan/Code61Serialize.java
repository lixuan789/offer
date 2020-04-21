package lixuan;

import util.TreeNode;

import java.util.ArrayList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Code61Serialize {
    private int index=-1;
    String Serialize(TreeNode root) {
        if(root==null){
            return "#";
        }else {
            return root.val+","+Serialize(root.left)+","+Serialize(root.right);
        }

    }
    TreeNode Deserialize(String str) {
        index++;
        String[] split = str.split(",");
        int len=split.length;
        if(index>len){
            return null;
        }
        TreeNode node=null;
        if(index<len&&!"#".equals(split[index])){
            node = new TreeNode(Integer.parseInt(split[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;

    }
}
