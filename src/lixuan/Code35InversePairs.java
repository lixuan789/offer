package lixuan;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class Code35InversePairs {
    /**
     * 暴力法：超时
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        int n=array.length;
        int res=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(array[i]>array[j]){
                    res++;
                }
            }
        }
        return res%1000000007;
    }

    /**
     * 分治法：nlogn
     * 类似归并排序
     * @param array
     * @return
     */
    int res;
    public int InversePairs1(int [] array) {
        int lo=0;
        int hi=array.length-1;
        res=0;
        mergeSortCore(array,lo,hi);
        return res;
    }

    private void mergeSortCore(int[] array, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int mid=lo+(hi-lo)/2;
        mergeSortCore(array,lo,mid);
        mergeSortCore(array,mid+1,hi);
        merge(array,lo,mid,hi);
    }

    private void merge(int[] array, int lo, int mid, int hi) {
        int[] temp=new int[hi-lo+1];
        int p1=lo;
        int p2=mid+1;
        int i=0;
        while (p1<=mid&&p2<=hi){
            if(array[p1]>array[p2]){
                res=(res+(mid-p1+1))%1000000007;
                temp[i++]=array[p2++];
            }else {
                temp[i++]=array[p1++];
            }
        }
        while (p1<=mid){
            temp[i++]=array[p1++];
        }
        while ((p2<=hi)){
            temp[i++]=array[p2++];
        }
        for (int j=0;j<temp.length;j++){
            array[lo+j]=temp[j];
        }

    }
}
