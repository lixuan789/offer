package lixuan;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Code23VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return VerifySquence(sequence,0,sequence.length-1);

    }

    private boolean VerifySquence(int[] sequence, int start, int end) {
        if(start>=end){//遍历结束
            return true;
        }
        int root=sequence[end];
        int i;
        for (i=start;i<end;i++){
            if(sequence[i]>root){
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if(sequence[j]<root){
                return false;
            }
        }
        return VerifySquence(sequence,start,i-1)&&VerifySquence(sequence,i,end-1);
    }
}
