package lixuan;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class Code49StrToInt {
    /**
     * int的范围-2147483648——2147483647
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        int res=0;
        boolean flag=false;//判断数字的正负
        char[] charArray = str.toCharArray();
        if(charArray[0]!='-'){
            flag=true;//为正数
        }
        int s=0;
        if(flag){
            if(charArray[0]=='+'){
                s=1;
            }else if(charArray[0]<'0'||charArray[0]>'9'){
                return 0;
            }
        }else {
            s=1;
        }
        for (int i=s;i<charArray.length;i++){
            if(charArray[i]<'0'||charArray[i]>'9') {
                return 0;
            }
            int num;
            //计算之前进行验证
            if(flag==true){//正数
                num=charArray[i]-'0';
                if(res==Integer.MAX_VALUE/10&&num>7){
                    return 0;
                }

            }else {
                num=-1*(charArray[i]-'0');
                if(res==Integer.MIN_VALUE/10&&num<-8){
                    return 0;
                }
            }
            res=res*10+num;
        }
        return res;
    }

    public static void main(String[] args) {
        Code49StrToInt strToInt = new Code49StrToInt();
        int num = strToInt.StrToInt("+214748364");
        System.out.println(num);
    }
}
