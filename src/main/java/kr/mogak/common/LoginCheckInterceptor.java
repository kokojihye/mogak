package kr.mogak.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        // 기존 session이 있으면 해당 session을, 없으면 null 반환
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("loginMember") == null) {
            log.info("미인증 사용자 요청");
            // TODO login으로 redirect
            // response.sendRedirect();
            return false;
        }
        return true;
    }
}
