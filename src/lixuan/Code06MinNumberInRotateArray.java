package lixuan;

public class Code06MinNumberInRotateArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    //方法一：线性查找
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    /**
     * 方法二：二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length==0){
            return 0;
        }
        int low=0;
        int high=array.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if(array[mid]>array[high]){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return array[low];
    }

    /**
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0){
            return 0;
        }
        int low=0;
        int high=array.length-1;
        //特殊情况10111
        while (low<high){
            if(array[low]<array[high]){//非递减序列
                return array[low];
            }
            int mid=low+(high-low)/2;
            if(array[mid]>array[low]){
                low=mid+1;
            }else if (array[mid]<array[high]){
                high=mid;
            }else {
                low++;
            }
        }
        return array[low];
    }
}
