package com.example.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个配置类需在放在 @ComponentScan 扫描包之外，否则会导致配置不生效
 * @SpringBootApplication 注解中 带有 @ComponentScan 注解，
 * 所以这个配置类的包不能在 启动类(CloudConsumeApplication) 所在包及子包下
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); // Ribbon 默认规则是轮询, 自定义为 随机;
    }

}
