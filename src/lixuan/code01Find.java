package lixuan;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class code01Find {
    public boolean Find(int target, int [][] array) {
        if(array.length==0){
            return false;
        }
        int m=array.length-1;//行数
        int n=array[0].length;//列数
        int temp_n=0;
        while (m>=0&&temp_n<n){
            if(array[m][temp_n]==target){
                return true;
            }
            if(array[m][temp_n]>target){
                m--;
            }else if(array[m][temp_n]<target){
                temp_n++;
            }
        }
        return false;
    }
}
