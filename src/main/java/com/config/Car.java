package com.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

/**
 * @author zyl
 * @date 2020/10/9 21:15
 * @describe 描述
 */
//@Component
public class Car implements InitializingBean, DisposableBean {

    public Car() {
        System.out.println("构造函数");
    }

    @PreDestroy
    public void aa() {
        System.out.println("@PreDestroy");
    }

    @PostConstruct
    public void bb() {
        System.out.println("@PostConstruct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("重写的DisposableBean方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("重写的InitializingBean方法");
    }

    public void initMethod() {
        System.out.println("initMethod");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod");
    }

//    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//    public Car car() {
//        return  new Car();
//    }
}
