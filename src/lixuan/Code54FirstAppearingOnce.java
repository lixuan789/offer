package lixuan;

import java.util.LinkedList;
import java.util.Queue;

public class Code54FirstAppearingOnce {
    private int[] charCnt=new int[126];
    private Queue<Character> queue=new LinkedList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch){
        charCnt[ch]++;
        if(charCnt[ch]==1){
            queue.offer(ch);
        }

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        char temp;
        while (!queue.isEmpty()){
            temp=queue.peek();
            if(charCnt[temp]==1){
                return temp;
            }else {
                queue.poll();
            }

        }
        return '#';
    }

}
