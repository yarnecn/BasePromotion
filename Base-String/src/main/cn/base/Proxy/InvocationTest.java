package cn.base.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-08-12 15:31
 **/
public class InvocationTest implements InvocationHandler {

    private Object target;

    InvocationTest(Object target){
        super();
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        Object result = method.invoke(target, args);
        System.out.println("调用之后");
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }



}
