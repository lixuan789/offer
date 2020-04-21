package lixuan;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 规律：小矩形同一列只能竖着放或横着放=>产生递推公式
 */
public class Code10RectCover {
    /**
     * 递归
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target<=2){
            return target;
        }
        return RectCover(target-2)+RectCover(target-1);
    }

    public int RectCover1(int target) {
        if(target<=2){
            return target;
        }
        int sum=2;
        int one=1;
        for (int i = 3; i <=target; i++) {
            sum=sum+one;
            one=sum-one;
        }
        return sum;
    }

}
