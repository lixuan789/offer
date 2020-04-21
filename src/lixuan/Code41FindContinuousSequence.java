package lixuan;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 、他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Code41FindContinuousSequence {
    /**
     * 双指针
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int left=1;
        int right=2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (right<=sum){
            int count=right-left+1;
            int tempSum=right+left;
            int temp=count*tempSum;
            if(2*right+1>2*sum){//前后2项相加大于sum可以直接break
                break;
            }
            if(temp==2*sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=left;i<=right;i++){
                    list.add(i);
                }
                res.add(list);
                right++;
            }
            if(temp<2*sum){
                right++;
            }
            if(temp>2*sum){
                left++;
            }
        }
        return res;
    }
}
