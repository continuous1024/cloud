package com.huan.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import com.huan.cloud.dao.dataobject.UserDO;
import com.huan.cloud.dao.mapper.UserMapper;
import com.huan.cloud.api.UserService;
import com.huan.cloud.api.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    // @Autowired
    // private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    public String getUserName(Long id) {
        // UserDO userDO = userMapper.getById(id);
        UserDO userDO = null;
        return userDO != null ? userDO.getName() : null;
    }

    public UserModel addUser(UserModel user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);

        // Long id = userMapper.insert(userDO);
        // user.setId(id);
        return user;
    }
}
