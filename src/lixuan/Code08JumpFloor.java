package lixuan;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Code08JumpFloor {
    /**
     * 方法一：就是一个斐波那契数列，和第7题一样
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target==0||target==1){
            return 1;
        }
        return JumpFloor(target-2)+JumpFloor(target-1);
    }

    public int JumpFloor1(int target) {
        if (target==0||target==1){
            return 1;
        }
        int sum=1;
        int one=1;
        for (int i = 2; i <=target ; i++) {
            sum=sum+one;
            one=sum-one;
        }
        return sum;
    }
}
