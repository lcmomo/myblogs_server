package cn.edu.nwsuaf.lims.service;
import cn.edu.nwsuaf.lims.model.User;
import cn.edu.nwsuaf.lims.core.Service;


/**
 * Created by liuchao Li on 2019/10/27.
 */
public interface UserService extends Service<User> {
    public User findByUserId(String userId);
    public User login(String username,String password);
    public User findByUsername(String username);
    public User findByEmail(String email);
}
