package lixuan;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 */
public class Code67cutRope {
    /**
     * 贪心算法：局部最优等价于全局最优
     * dp[i]表示长度为i的乘积最大值,则2个局部最大值相乘肯定也是全局的最大值
     * dp[i]=max{Math.max(dp[j],j)*Math.max(dp[i-j],i-j)}
     * dp[j]代表了切分后的最大值，当属于dp[i]的某一段时其最大值也可以是dp[j]不切分的值，即本身的长度
     * 证明方法：剪切-粘贴方法
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if(target<2){
            return 0;
        }
        int[] dp=new int[target+1];//dp[i]表示长度为i的乘积最大值
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=target;i++){
            int tempMax=Integer.MIN_VALUE;
            for (int j=1;j<=i/2;j++){
                int num=Math.max(dp[j],j)*Math.max(dp[i-j],i-j);//经典
                if(num>tempMax){
                    tempMax=num;
                }
            }
            dp[i]=tempMax;
        }
        return dp[target];
    }
}
