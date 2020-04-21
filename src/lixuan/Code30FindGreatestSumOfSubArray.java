package lixuan;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Code30FindGreatestSumOfSubArray {
    /**
     * 方法一：动态规划
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int []dp=new int[array.length];
        int max=array[0];
        dp[0]=array[0];
        for (int i = 1; i < array.length; i++) {
            int newMax=dp[i-1]+array[i];
            if(newMax>array[i]){
                dp[i]=newMax;
            }else {
                dp[i]=array[i];
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    /**
     * 方法二：优化
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max=array[0];
        int curSum=array[0];
        for (int i=1;i<array.length;i++){
            if (curSum<0){
                curSum=array[i];
            }else {
                curSum+=array[i];
            }
            max=Math.max(max,curSum);
        }
        return max;
    }

    /**
     * 分治法
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {

        int right=array.length-1;
        return fun(array,0,right);

    }

    private int fun(int[] array, int left, int right) {
        if(left==right){
            return array[left];
        }
        int mid=left+(right-left)/2;
        int leftMax=fun(array,left,mid);
        int rightMax=fun(array,mid+1,right);
        int midMax=partition(array,left,right);
        if(leftMax>rightMax&&leftMax>midMax){
            return leftMax;
        }else if(rightMax>leftMax&&rightMax>midMax){
            return rightMax;
        }else {
            return midMax;
        }
    }

    private int partition(int[] array, int left, int right) {
        int mid=left+(right-left)/2;
        int leftSum=Integer.MIN_VALUE;
        int leftTemp=0;
        for (int i=mid;i>=left;i--){
            leftTemp+=array[i];
            if(leftTemp>leftSum){
                leftSum=leftTemp;
            }
        }
        int righSum=Integer.MIN_VALUE;
        int rightTemp=0;
        for (int i=mid+1;i<=right;i++){
            rightTemp+=array[i];
            if(rightTemp>righSum){
                righSum=rightTemp;
            }
        }

        return leftSum+righSum;
    }

}
