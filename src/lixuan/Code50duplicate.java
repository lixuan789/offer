package lixuan;

public class Code50duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     * 那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length==0){
            duplication[0]=-1;
            return false;
        }
        int[] hashmap = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            hashmap[numbers[i]]++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if(hashmap[numbers[i]]>1){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 数组的长度为 n 且所有数字都在 0 到 n-1 的范围内，我们可以将每次遇到的数进行"归位"，
     * 当某个数发现自己的"位置"被相同的数占了，则出现重复。
     * 扫描整个数组，当扫描到下标为 i 的数字时，首先比较该数字（m）是否等于 i，如果是，则接着扫描下一个数字；
     * 如果不是，则拿 m 与第 m 个数比较。如果 m 与第 m 个数相等，则说明出现重复了；
     * 如果 m 与第 m 个数不相等，则将 m 与第 m 个数交换，将 m "归位"，再重复比较交换的过程，直到发现重复的数
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers==null||length==0){
            duplication[0]=-1;
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                int temp=numbers[i];
                numbers[i]=numbers[temp];
                numbers[temp]=temp;
            }
        }
        return false;
    }
}
