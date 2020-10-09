package com;

import com.condition.LinuxCondition;
import com.condition.WindowsCondition;
import com.entity.QuartzJobEntity;
import com.entity.QuartzLogEntity;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zyl
 * @date 2020/10/8 16:23
 * @describe 描述
 */
@Service
public class TestService {

    @Bean("a")
    @Lazy
    @Conditional(WindowsCondition.class)
    public QuartzJobEntity quartzJobEntity() {
        System.out.println("我是单例，第一次扫描被调用");
        return new QuartzJobEntity();
    }

    @Bean("b")
    @Lazy
    @Conditional(LinuxCondition.class)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QuartzJobEntity quartzLogEntity() {
        System.out.println("我是原型，用到时才被调用");
        return new QuartzJobEntity();
    }
}

