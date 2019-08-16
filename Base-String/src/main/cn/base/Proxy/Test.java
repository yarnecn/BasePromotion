package cn.base.Proxy;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-08-12 15:43
 **/
public class Test {


    public static void main(String[] args) {
        CglibProxy();

    }

    public static void JDKProxy(){
        ProxyModelService proxyModelService=new ProxyModelServiceimpl();
        InvocationTest handler = new InvocationTest(proxyModelService);
        ProxyModelService proxy = (ProxyModelService) handler.getProxy();
        proxy.add();
    }


    public static void CglibProxy(){
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        ProxyModelServiceimpl proxyImp = (ProxyModelServiceimpl)proxy.getProxy(ProxyModelServiceimpl.class);
        proxyImp.add();
    }

}
