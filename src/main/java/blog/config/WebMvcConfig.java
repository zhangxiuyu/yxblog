package blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 实现 WebMvcConfigurer 中的添加拦截器方法
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //使用拦截器注册表进行添加 自定义拦截器
        registry.addInterceptor(new MyInterceptor())
                //添加拦截路径
                .addPathPatterns(
                        "/**"
                )
                //设置放行路径
                .excludePathPatterns(
                    "/",
                    "/weibo",
                    "/weiboLogin",
                    "/QQ",
                    "/QQLogin",
                    "/githubUrl",
                    "/gitHub",
                    "/gitHub",
                    "/article_type/**",
                    "/article_type/**/**",
                    "/article_type/**/**",
                    "/article_label/**",
                    "/article_label/**/**",
                    "/article/**",
                    "/articleList/**",
                    "/articleList",
                    "/articleHot",
                    "/articleHot/**"
                );

    }

}
