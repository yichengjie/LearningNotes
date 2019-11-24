package com.yicj.api.import1.service.impl;

import com.yicj.api.entity.User;
import com.yicj.api.import1.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int save(User user) {
        System.out.println("调用了当前方法..");
        return 1;
    }
}
