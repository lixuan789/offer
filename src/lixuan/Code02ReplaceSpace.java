package lixuan;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Code02ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 方法二：调用API
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {

        return str.toString().replace(" ","%20");
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }
}
