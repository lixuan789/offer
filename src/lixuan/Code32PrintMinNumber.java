package lixuan;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Code32PrintMinNumber {
    /**
     * 比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
     * 如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
          if(numbers==null||numbers.length==0){
              return "";
          }
          for (int i=0;i<numbers.length-1;i++){
              for (int j=i+1;j<numbers.length;j++){
                  double sum1=Long.valueOf(numbers[i]+""+numbers[j]);
                  double sum2=Long.valueOf(numbers[j]+""+numbers[i]);
                  if(sum1>sum2){
                      int temp=numbers[j];
                      numbers[j]=numbers[i];
                      numbers[i]=temp;
                  }
              }
          }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            res.append(numbers[i]+"");
        }
        return res.toString();
    }

    public String PrintMinNumber1(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String sum1=str1+""+str2;
                String sum2=str2+""+str1;
                return sum1.compareTo(sum2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (Integer num : list) {
            res.append(num+"");
        }
        return res.toString();
    }
}
