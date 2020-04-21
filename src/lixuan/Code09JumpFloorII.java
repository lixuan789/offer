package lixuan;

import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Code09JumpFloorII {
    /**
     * 动态规划
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target==0||target==1){
            return 1;
        }
        int dp[]=new int[target+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j];
            }
        }
        return dp[target];
    }

    /**
     * 数学公式：等比数列
     * @param target
     * @return
     */
    public int JumpFloorII1(int target) {
        if(target==0||target==1){
            return 1;
        }
        int sum=1;
        for (int i = 1; i <=target-1 ; i++) {
            sum*=2;
        }
        return sum;
    }
}
