package kr.mogak.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
/*
* 허가되지 않은 접근 확인
*/
@Slf4j
public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession(false);

        if(!session.getAttribute("author").equals("MASTER")) {
            log.info("미인가 사용자 요청");
            // TODO 경고
            return false;
        }
        return true;
    }
}
