package lixuan;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Code53isNumeric {
    /**
     * 方法一：简单模拟
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        int index=0;
        int count=0;
        if(str[0]=='-'||str[0]=='+'){
            index++;
        }
        if((str[index]<'0'||str[index]>'9')&&str[index]!='.'){//第一位数字-.123为true
            return false;
        }
        while (index<str.length){
            if(str[index]=='.'){//例如1.2.3
                count++;
                if(count>=2){
                    return false;
                }
                if(index<str.length-1&&(str[index+1]=='e'||str[index+1]=='E')){
                    return false;
                }
            }
            if((str[index]<'0'||str[index]>'9')&&str[index]!='e'&&str[index]!='E'&&str[index]!='.'){
                return false;
            }

            if(str[index]=='e'||str[index]=='E'){
                if(index==str.length-1){//最后一位为e,例如12e
                    return false;
                }
                index++;
                while (index<str.length){
                    if(str[index]=='-'||str[index]=='+'){
                        index++;
                    }else {
                        if(str[index]=='.'){
                            return false;
                        }else if(str[index]<'0'||str[index]>'9'){
                            return false;
                        }
                        index++;
                    }
                }
            }
            index++;

        }
        return true;
    }


    /**
     *方法二：正则表达式
     * 链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?f=discussion
     * 来源：牛客网
     *
     * 以下对正则进行解释:
     * [\\+\\-]?            -> 正或负符号出现与否
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
     *                         否则一起不出现
     * ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
     *                         紧接着必须跟着整数；或者整个部分都不出现
     * @param str
     * @return
     */
    public boolean isNumeric1(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    public static void main(String[] args) {
        Code53isNumeric test = new Code53isNumeric();
        char[] chars = "123.".toCharArray();
        boolean numeric = test.isNumeric(chars);
        System.out.println(numeric);
    }

}
