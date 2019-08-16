package cn.base.Reflection;

import java.lang.reflect.InvocationHandler;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-08-12 15:43
 **/
public class Test {


    public static void main(String[] args) {

        ProxyModelService proxyModelService=new ProxyModelServiceimpl();
        InvocationTest handler = new InvocationTest(proxyModelService);
        ProxyModelService proxy = (ProxyModelService) handler.getProxy();
        proxy.add();

    }
}
