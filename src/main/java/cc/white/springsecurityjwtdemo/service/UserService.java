package cc.white.springsecurityjwtdemo.service;

import cc.white.springsecurityjwtdemo.component.JwtUserDetails;
import cc.white.springsecurityjwtdemo.dao.UserMapper;
import cc.white.springsecurityjwtdemo.dto.Resp;
import cc.white.springsecurityjwtdemo.dto.RespFactory;
import cc.white.springsecurityjwtdemo.model.User;
import cc.white.springsecurityjwtdemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserMapper userMapper, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
    }

    public User findById(String id) {
        return userMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    public Resp<Object> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user.getPassword().equals(password)) {
            JwtUserDetails jwtUserDetails = new JwtUserDetails(user);
            String token = jwtUtil.generateToken(jwtUserDetails);
            return RespFactory.success(token);
        } else {
            return RespFactory.error("用户名或密码错误");
        }
    }
}
