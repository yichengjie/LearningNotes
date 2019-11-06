package com.yicj.hello.factory;

import com.yicj.hello.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<User> {
    @Setter
    private String username ;
    @Setter
    private String addr ;

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setAddr(addr);
        return user ;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
