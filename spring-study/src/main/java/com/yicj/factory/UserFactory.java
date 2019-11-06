package com.yicj.factory;

import com.yicj.entity.User;
import lombok.Getter;
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
