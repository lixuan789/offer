package lixuan;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Code37GetNumberOfK {
    /**
     * 二分查找
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int left=0,right=array.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(array[mid]<k){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        int res=0;
        for (int i=left;i<array.length;i++){
            if(array[i]==k){
                res++;
            }else {
                break;
            }
        }
        if(left>0){
            for (int j=left-1;j>=0;j--){
                if(array[j]==k){
                    res++;
                }else {
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
     * 这两个数应该插入的位置，然后相减即可。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK1(int [] array , int k) {
        return biSearch(array, k+0.5) - biSearch(array, k-0.5);
    }

    private int biSearch(int[] array, double num) {
        int left=0,right=array.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(array[mid]<num){
                left=mid+1;
            }else if(array[mid]>num){
                right=mid-1;
            }
        }
        return left;
    }
}
