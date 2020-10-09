package com.condition;

import com.entity.QuartzLogEntity;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zyl
 * @date 2020/10/8 18:07
 * @describe 描述
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition("com.entity.QuartzLogEntity");
        if (b) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(QuartzLogEntity.class);
            RootBeanDefinition rootBeanDefinition1 = new RootBeanDefinition(QuartzLogEntity.class);
            registry.registerBeanDefinition("aa", rootBeanDefinition);
            registry.registerBeanDefinition("aabb", rootBeanDefinition1);
        }
    }
}
