package lixuan;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Code51multiply {
    public int[] multiply(int[] A) {
        int n=A.length;
        int[] B = new int[n];
        int index=0;
        for (int i = 0; i < n; i++) {
            int num=1;
            for (int j=0;j<n;j++){
                if(j!=index){
                    num*=A[j];
                }
            }
            B[index]=num;
            index++;
        }
        return B;

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?f=discussion
     * 来源：牛客网
     *
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，
     * 然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     * @param A
     * @return
     */
    public int[] multiply1(int[] A) {
        int n=A.length;
        int[] B = new int[n];
        if(n!=0){
            B[0]=1;
            for (int i = 1; i < n; i++) {
                B[i]=B[i-1]*A[i-1];
            }
            int temp=1;
            for (int i=n-2;i>=0;i--){
                temp*=A[i+1];
                B[i]*=temp;
            }
        }
        return B;
    }
}
