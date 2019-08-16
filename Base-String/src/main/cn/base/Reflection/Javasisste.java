package cn.base.Reflection;

import javassist.*;

import java.io.IOException;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-08-07 14:31
 **/
public class Javasisste {


       public void test() {
        System.out.println("执行test");
    }

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        Javasisste javasisste = new Javasisste();
        javasisste.test();
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("cn.base.Reflection.Javasisste");
        CtMethod method = pool.getMethod("cn.base.Reflection.Javasisste", "test");
        CtMethod newMethod = CtNewMethod.copy(method, ctClass, null);

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("System.out.println(\"修改之后执行test\");");
        newMethod.setName("newTest");
        newMethod.setBody(stringBuffer.toString());
        ctClass.writeFile();
        new Javasisste().test();
    }
}
