package lixuan;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Code12Power {
    /**
     * 普通方法
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result=1.0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result*=base;
        }
        if (exponent<0){
            return 1/result;
        }
        return result;
    }

    /**
     * 快速幂算法
     * @param base
     * @param exponent
     * @return
     */
    public double Power1(double base, int exponent) {
        double result=1;
        boolean flag=false;
        if(exponent<0){
            flag=true;
            exponent=-exponent;
        }
        while (exponent>0){
            if((exponent&1)==1){
                result*=base;
            }
            exponent>>=1;
            base*=base;
        }
        if(flag){
            return 1/result;
        }
        return result;
    }

    /**
     * 递归
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        double result = getPow(base, Math.abs(exponent));
        if(exponent<0){
            return 1/result;
        }
        return result;
    }

    private double getPow(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        double half=getPow(base,exponent>>1);
        if(exponent%2==0){
            return half*half;
        }else {
            return half*half*base;
        }
    }
}
