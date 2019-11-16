package cn.edu.nwsuaf.lims.service.impl;

import cn.edu.nwsuaf.lims.dao.UserMapper;
import cn.edu.nwsuaf.lims.model.User;
import cn.edu.nwsuaf.lims.service.UserService;
import cn.edu.nwsuaf.lims.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Created by liuchao Li on 2019/10/27.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User findByUserId(String userId) {
        Condition condition = new Condition(User.class);
        condition.createCriteria()
                .andEqualTo("userid",userId);
        List<User> usersn = findByCondition(condition);
        User user=null;
        if(usersn.size()>0){
            user=new User();
            return user;
        }
        else

            return null;
    }

    @Override
    public User login(String email, String password) {
        Condition condition = new Condition(User.class);
        condition.createCriteria()
                .andEqualTo("email",email);


        //System.out.println("\n\n"+username);
        List<User> usersn = findByCondition(condition);
        //System.out.println("\n\nu"+usersn);
        User user=null;
        if (usersn.size() > 0) {
            Condition condition2 = new Condition(User.class);
            condition2.createCriteria()
                    .andEqualTo("email",email)
                    .andEqualTo("password",  password);
            List<User> users = findByCondition(condition2);
            if(users.size()>0) {
                user = users.get(0);

                return user;
            }else{
                user=new User();
                user.setUsername("err");
                return  user;
            }

        } else
            return null;
    }

    @Override
    public User findByUsername(String username) {
        Condition condition = new Condition(User.class);
        condition.createCriteria()
                .andEqualTo("username",username);
        List<User> usersn = findByCondition(condition);
        User user=null;
        if(usersn.size()>0){
            user=new User();
            return user;
        }
        else

            return null;
    }

    @Override
    public User findByEmail(String email) {
        Condition condition = new Condition(User.class);
        condition.createCriteria()
                .andEqualTo("email",email);
        List<User> usersn = findByCondition(condition);

        if(usersn.size()>0){

            return usersn.get(0);
        }
        else

            return null;
    }


}
