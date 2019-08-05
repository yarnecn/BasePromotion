package cn.base.Integer;

/**
 * @program: BasePromotion
 * @description: Integer的缓存机制
 * @author: yarne
 * @create: 2019-07-19 19:47
 **/
public class IntegerCache {

    public static void main(String[] args) {


        Integer i1 = -129;
        Integer i2 = -129;
        Integer i3 = 128;
        Integer i4 = 128;
        Integer i5 = 127;
        Integer i6 = 127;


        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i5 == i6);
    }

}
