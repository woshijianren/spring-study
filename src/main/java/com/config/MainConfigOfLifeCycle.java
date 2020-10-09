package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zyl
 * @date 2020/10/9 21:15
 * @describe 描述
 */
@Component
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Car car() {
        return  new Car();
    }
}
