package lixuan;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Code33GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0){
            return 0;
        }
        int p2=0,p3=0,p5=0;//指向三个潜在成为最小丑数的位置
        int []res=new int[index];
        res[0]=1;
        for (int i = 1; i < index; i++) {
            res[i]=Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            if(res[i]==res[p2]*2)p2++;
            if(res[i]==res[p3]*3)p3++;
            if(res[i]==res[p5]*5)p5++;
        }
        return res[index-1];
    }
}
