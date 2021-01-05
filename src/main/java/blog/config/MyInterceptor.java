package blog.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyInterceptor implements HandlerInterceptor {



    /**
     * 通过实现 HandlerInterceptor中的预先处理，方法进行请求验证操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        if (StringUtils.isEmpty(token)) {
            System.out.println("token为空 登录失效");
            response.setStatus(203);
            //未登录自动跳转界面
//            response.sendRedirect("/");
            return false;
        }
        return true;
    }
    /**
     * postHandle（后期处理）
     * 该方法在preHandle返回为true，执行完Controller层的方法后执行
     * 可以修改ModelAndView
     * ps：返回的为json数据时不能修改（@RestController)此类注解修饰不能修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

    }

    /**
     * afterCompletion（完成后处理）
     * 当请求完成后执行，一般用户数据缓存清楚
     */
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception e){

    }

}
