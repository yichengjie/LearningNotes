JMX要求：
    1. MBean实现类和接口类必须放在同一个包下，否则报错
    2. 接口的名称必须是类名加上MBean

dubbo:
   dubbo中service方法返回的自定义对象必须实现Serializable接口，否则消费端无法调通服务端

