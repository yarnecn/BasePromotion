package cn.base.String;

/**
 * @program: BasePromotion
 * @description: String的不可变性
 * @author: yarne
 * @create: 2019-07-19 20:05
 **/
public class BashString {
    private static final Integer Num = 100000;


    public static void main(String[] args) {

        //+ 和 concat 还有 StringBuffer的效率
        // StringBufferOrAdd();

        StringReplace();

    }


    public static void StringBufferOrAdd() {
        System.out.println(System.currentTimeMillis());
        String string = "a";
        for (int a = 0; a <= Num; a++) {
            string += "a";
        }
        System.out.println(System.currentTimeMillis());
        for (int a = 0; a <= Num; a++) {
            string = string.concat("a");
        }
        System.out.println(System.currentTimeMillis());
        StringBuffer stringBuffer = new StringBuffer("a");
        for (int a = 0; a <= Num; a++) {
            stringBuffer.append("a");
        }
        System.out.println(System.currentTimeMillis());
    }


    public static void StringReplace() {
        String str = "abcdefjaba";

        String replaceFirst = str.replaceFirst("ab", "ba");
        System.out.println(replaceFirst);

        String replace = replaceFirst.replace("ba", "love");
        System.out.println(replace);

        String replaceAll = replace.replaceAll("love", "ba");
        System.out.println(replaceAll);

    }
}
