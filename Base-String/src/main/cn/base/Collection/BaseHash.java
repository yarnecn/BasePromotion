package cn.base.Collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @program: BasePromotion
 * @description: Hash 深入
 * @author: yarne
 * @create: 2019-07-21 16:48
 **/
public class BaseHash {


    public static void baseHashMap() {
       ArrayList arrayList=new ArrayList();
       System.out.println(arrayList.stream());
    }

  public static void stream() {
        HashMap hashMap=new HashMap();
        hashMap.put(null,null);
        hashMap.put("a",null);
      hashMap.put(null,"1");
      System.out.println(hashMap.toString());

  }



    public static void main(String[] args) {
        stream();
    }


}
                 