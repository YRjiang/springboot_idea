package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    /**
     * 将Swagger2 的swagger-ui.html加入资源路径下,否则Swagger2静态页面不能访问。要想使资源能够访问，可以有两种方法
     * 一：需要配置类继承 WebMvcConfigurationSupport 类，实现 addResourceHandlers 方法。
     *      但是实现了WebMvcConfigurationSupport以后，Spring Boot的 WebMvc自动配置就会失效，具体表现比如访问不到
     *      静态资源（js，css等）了，这是因为WebMvc的自动配置都在WebMvcAutoConfiguration类中，但是类中有这个注解
     *      @ConditionalOnMissingBean({WebMvcConfigurationSupport.class})  意思是一旦在容器中检测到
     *      WebMvcConfigurationSupport 这个类， WebMvcAutoConfiguration 类中的配置都不生效。
     *      所以一旦我们自己写的配置类继承了 WebMvcConfigurationSupport ，相当于容器中已经有了 WebMvcConfigurationSupport ，
     *      所有默认配置都不会生效，都得自己在配置文件中配置。
     * 二：继承 WebMvcConfigurer 接口， 网上有人说使用该方法会导致date编译等问题 ，可能在配置文件中得到解决，
     *      本人没有碰到，不多做解释
     * @param registry
     */


    /**
     *
     * swagger-ui.html 位于 springfox-swagger-ui jar 包中的META-INF/resources/目录下，
     * 项目编译后 swagger-ui.html 将添加到 classpath 的/META-INF/resources/下，
     * 所以添加 mapping="/webjars/**" 可通过localhost:端口号/项目名/swagger-ui.html打开SwaggerUI
     *
     * @param registry
     */


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
