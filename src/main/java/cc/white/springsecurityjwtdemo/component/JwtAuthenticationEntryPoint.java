package cc.white.springsecurityjwtdemo.component;

import cc.white.springsecurityjwtdemo.dto.Resp;
import cc.white.springsecurityjwtdemo.dto.RespFactory;
import cc.white.springsecurityjwtdemo.utils.JsonUtils;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 响应 401 用户未提供身份验证凭据，或者没有通过身份验证。
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Resp<Object> error = RespFactory.tokenError();
        response.getWriter().write(JsonUtils.bean2Json(error));
    }
}
