package com;

import com.entity.Color;
import com.entity.QuartzJobEntity;
import com.entity.QuartzLogEntity;
import com.factory.ColorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zyl
 * @date 2020/9/24 22:25
 * @describe 描述
 */
@SpringBootApplication
public class SpringApp {

//    @Bean
//    public ColorFactoryBean colorFactoryBean() {
//        return new ColorFactoryBean();
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = SpringApplication.run(SpringApp.class, args);
//        System.out.println(configApplicationContext.getBean("car"));
        configApplicationContext.close();
//        Object car = configApplicationContext.getBean("car");
//        Object color21 = configApplicationContext.getBean("color2");
//        System.out.println(color21);
////        ColorFactoryBean color1 = configApplicationContext.getBean(ColorFactoryBean.class);
//        Object bean = configApplicationContext.getBean("&colorFactoryBean");
//        Object bean1 = configApplicationContext.getBean("colorFactoryBean");
//        System.out.println(bean);
//        System.out.println(bean1);
//        ColorFactoryBean color2 = configApplicationContext.getBean(ColorFactoryBean.class);
//        Color color1 = (Color) configApplicationContext.getBean("colorFactoryBean");
//        System.out.println(color1);
//        Color color2 = (Color) configApplicationContext.getBean("colorFactoryBean");
//        System.out.println(color2);
//        System.out.println(color1 == color2);
//        String[] beanDefinitionNames = configApplicationContext.getBeanNamesForType(QuartzJobEntity.class);
//        String[] beanDefinitionNames = configApplicationContext.getBeanNamesForType(QuartzLogEntity.class);
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }


//        System.out.println(configApplicationContext.getBean("a") == configApplicationContext.getBean("a"));
////        System.out.println(configApplicationContext.getBean("b") == configApplicationContext.getBean("b"));
//        ConfigurableEnvironment environment = configApplicationContext.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);


    }
}
