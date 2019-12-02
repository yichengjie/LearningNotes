package com.yicj.jmx;

import com.yicj.s2.ext.ShutdownLatch;

import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JMXdemo {
	/**
	 * @param args
	 * @throws NullPointerException 
	 * @throws MalformedObjectNameException 
	 * @throws NotCompliantMBeanException 
	 * @throws MBeanRegistrationException 
	 * @throws InstanceAlreadyExistsException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
		MBeanServer server=ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName=new ObjectName("ext:type=User");
		User bean=new User();
		server.registerMBean(bean, objectName);
		String oldName=null;
		String oldPwd=null;
		System.out.println("ext started!!!");
		while(true){
			if(oldName != bean.getName()|| oldPwd != bean.getPasswd()){
				System.out.println(bean.getName()+":"+bean.getPasswd());
				oldName=bean.getName();
				oldPwd=bean.getPasswd();
			}
			Thread.sleep(1000);
		}
	}
}
