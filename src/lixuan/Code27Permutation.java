package lixuan;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Code27Permutation {
    private ArrayList<String> res=new ArrayList<>();
    private TreeSet<String> paths=new TreeSet<>();//去重
    private StringBuilder path=new StringBuilder();
    private boolean[] visited;

    /**
     * 方法一：回溯法+减枝
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if("".equals(str)||str.length()==0){
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);//排序以便减枝
        visited=new boolean[strs.length];
        dfs(strs,0);
        res.addAll(paths);
        return res;
    }

    private void dfs(char[] strs, int len) {
        if (len==path.length()){
            paths.add(path.toString());
            return;
        }
        for (int i=0;i<strs.length;i++){
            if (!visited[i]){
                visited[i]=true;
                path.append(strs[i]);
                dfs(strs,len+1);
                path.deleteCharAt(path.length()-1);
                visited[i]=false;
            }
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?f=discussion
     * 来源：牛客网
     *
     * 对于无重复值的情况
     *
     * 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
     * *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，
     * 然后继续处理子串。
     *
     *      假如有重复值呢？
     *      由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——
     *      如果一个数与后面的数字相同那么这两个数就不交换了。
     *      例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
     *      但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
     *      由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
     *
     *      换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，
     *      此时由于第三个数等于第二个数，
     *      所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation1(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);//回溯
                }
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
