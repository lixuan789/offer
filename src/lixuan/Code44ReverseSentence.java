package lixuan;

import java.util.Arrays;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Code44ReverseSentence {
    /**
     * 方法一：利用API
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length-1; i >=0 ; i--) {
            res.append(strings[i]);
            if(i>0){
                res.append(" ");
            }
        }
        return res.toString();
    }

    public String ReverseSentence1(String str) {
        char[] chars = str.toCharArray();
        reversal(chars,0,str.length()-1);
        StringBuilder res = new StringBuilder();
        int s=0,e=0,i=0;
        while (i<str.length()){
            while (i<str.length()&&chars[i]==' '){
                i++;
            }
            s=i;//单词的开始
            while (i<str.length()&&chars[i]!=' '){
                i++;
            }
            e=i;//单词的结束
            reversal(chars,s,e-1);
        }
        for (char c : chars) {
            res.append(c);
        }
        return res.toString();

    }
    private void reversal(char[] chars,int left,int right){
        while (left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
}
