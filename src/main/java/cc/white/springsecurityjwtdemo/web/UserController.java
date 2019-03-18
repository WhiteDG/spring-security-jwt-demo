package cc.white.springsecurityjwtdemo.web;

import cc.white.springsecurityjwtdemo.component.JwtUserDetails;
import cc.white.springsecurityjwtdemo.config.JwtConfig;
import cc.white.springsecurityjwtdemo.dto.LoginReq;
import cc.white.springsecurityjwtdemo.dto.Resp;
import cc.white.springsecurityjwtdemo.dto.RespFactory;
import cc.white.springsecurityjwtdemo.model.User;
import cc.white.springsecurityjwtdemo.service.UserService;
import cc.white.springsecurityjwtdemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Resp<User> getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(jwtConfig.getHeader()).substring(7);
        String username = jwtUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userDetailsService.loadUserByUsername(username);
        return RespFactory.success(user.getUser());
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Resp<Object> login(@Validated LoginReq loginReq, BindingResult bindingResult) {
        return userService.login(loginReq.getUsername(), loginReq.getPassword());
    }
}
