package cc.white.springsecurityjwtdemo.component;

import cc.white.springsecurityjwtdemo.dto.Resp;
import cc.white.springsecurityjwtdemo.dto.RespFactory;
import cc.white.springsecurityjwtdemo.utils.JsonUtils;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 响应 403 用户没有访问权限。
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        Resp<Object> error = RespFactory.forbiddenError();
        response.getWriter().write(JsonUtils.bean2Json(error));
    }
}
