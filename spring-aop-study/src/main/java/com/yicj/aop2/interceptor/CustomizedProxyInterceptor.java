package com.yicj.aop2.interceptor;
import com.yicj.aop2.holder.ProxyBeanHolder;
import com.yicj.aop2.util.ConfigurationUtil;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.util.List;

public class CustomizedProxyInterceptor implements MethodInterceptor  {
    //用于接收切面信息
    private List<ProxyBeanHolder> proxyBeanHolderList;
    public CustomizedProxyInterceptor(List<ProxyBeanHolder> proxyBeanHolderList){
        this.proxyBeanHolderList = proxyBeanHolderList;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        //处理前置及环绕前置通知
        for (ProxyBeanHolder proxyBeanHolder : proxyBeanHolderList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            //System.out.println("annotationName : " + annotationName);
            if (annotationName.equals(ConfigurationUtil.BEFORE) ||
                    annotationName.equals(ConfigurationUtil.AROUND)) {
                this.doProxy(proxyBeanHolder,annotationName);
            }
        }
        Object result ;
        try{
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            System.out.println("get ex:"+e.getMessage());
            throw e;
        }
        //处理前置及环绕前置通知
        for (ProxyBeanHolder proxyBeanHolder: proxyBeanHolderList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(ConfigurationUtil.AFTER) ||
                    annotationName.equals(ConfigurationUtil.AROUND))
                this.doProxy(proxyBeanHolder, annotationName);
        }
        return result;
    }

    /**
     * 处理代理操作
     * @param proxyBeanHolder
     */
    private void doProxy(ProxyBeanHolder proxyBeanHolder, String annotationName){
        String className = proxyBeanHolder.getClassName();
        String methodName = proxyBeanHolder.getMethodName();
        //System.out.println("className =====> " + className);
        //System.out.println("methodName ====> " + methodName); // testBefore ,testAfter ,testAround
        Object clazz ;
        try {
            clazz = Class.forName(className);
            Method[] methods = ((Class) clazz).getMethods();
            for (Method poxyMethod : methods){
                if (poxyMethod.getName().equals(methodName)){
                    if(ConfigurationUtil.BEFORE.equals(annotationName)){
                        poxyMethod.invoke(((Class) clazz).newInstance(),null);
                    }else {
                        poxyMethod.invoke(((Class) clazz).newInstance(),null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
