package com.yicj.dubbo.ext;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShutdownLatch implements ShutdownLatchMBean {
    protected AtomicBoolean running = new AtomicBoolean(false) ;
    public  long checkIntervalInSeconds = 10 ;
    private String domain = "com.yicj.lifecycles" ;

    public ShutdownLatch(){}
    public ShutdownLatch(String domain){
        this.domain = domain ;
    }

    public void await() throws Exception {
        if(running.compareAndSet(false,true)){
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer() ;
            //ObjectName objectName = new ObjectName(domain, "name", "ShutdownLatch");
            ObjectName objectName = new ObjectName("ext:type=ShutdownLatch");
            mBeanServer.registerMBean(this,objectName) ;
            while (running.get()){
                TimeUnit.SECONDS.sleep(checkIntervalInSeconds);
            }
        }
    }

    @Override
    public String shutdown() {
        if(running.compareAndSet(true,false)){
            return "shutdown single sent ,shutting downing...." ;
        }else {
            return "shutdown signal had bean sent, no need again an again and again ..." ;
        }
    }
}
