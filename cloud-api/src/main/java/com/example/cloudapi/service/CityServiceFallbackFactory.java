package com.example.cloudapi.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component // 千万不要忘记添加 这个注解，否则 不生效
public class CityServiceFallbackFactory implements FallbackFactory<ICityService> {

    @Override
    public ICityService create(Throwable throwable) {
        return new ICityService() {
            @Override
            public String get() {
                return "降级处理 get !!!";
            }

            @Override
            public String list() {
                return "降级处理 list !!!";
            }

            @Override
            public String add() {
                return "降级处理 add !!!";
            }
        };
    }

}
