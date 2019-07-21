package cn.base.Collection;

import java.util.*;

/**
 * @program: BasePromotion
 * @description: String
 * @author: yarne
 * @create: 2019-07-21 11:22
 **/
public class BaseCollection {

    private static final Integer Num = 200000;
    private static final Integer NowNum = 50000;

    static ArrayList arrayList = new ArrayList();

    static LinkedList linkedList = new LinkedList();

    static Vector vector = new Vector<>();

    static {
        for (int i = 0; i <= Num; i++) {
            arrayList.add("aasdasd");
            linkedList.add("azxcasd");
        }
        BaseListRandomAdd();
    }

    /**
     * 随机添加效率比较
     */
    public static void BaseListRandomAdd() {
        Random random = new Random();

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <= NowNum; i++) {
            arrayList.add(random.nextInt(NowNum), "aasdasd");
        }

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <= NowNum; i++) {
            linkedList.add(random.nextInt(NowNum), "azxcasd");
        }
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 尾部添加比较
     */
    public static void BaseListAdd() {
        Random random = new Random();

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <= NowNum; i++) {
            arrayList.add("aasdasd");
        }

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <= NowNum; i++) {
            linkedList.add("azxcasd");
        }

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <= NowNum; i++) {
            vector.add("azxcasd");
        }
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 尾部添加比较
     */
    public static void BaseSynchronizedList() {

        List<Object> objects = Collections.synchronizedList(linkedList);
        for (Object object:objects){
            System.out.println(object);
        }

    }


    public static void main(String[] args) {
        BaseSynchronizedList();
    }
}
