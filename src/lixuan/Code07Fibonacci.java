package lixuan;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Code07Fibonacci {

    /**
     * 方法一：递归
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return Fibonacci(n-2)+Fibonacci(n-1);
    }

    /**
     * 方法二：动态规划
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 方法三：动态规划优化
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int dp2=1;
        int dp1=1;
        int result=0;
        for (int i = 3; i <=n ; i++) {
            result=dp1+dp2;
            dp2=dp1;
            dp1=result;
        }
        return result;
    }

    /**
     * 继续优化
     * @param n
     * @return
     */
    public int Fibonacci3(int n) {
        if(n<=1){
            return n;
        }
        int sum=1;
        int one=0;
        for (int i = 2; i <=n ; i++) {
            sum=sum+one;
            one=sum-one;
        }
        return sum;
    }
}
