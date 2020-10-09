package com.factory;

import com.entity.Color;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author zyl
 * @date 2020/10/8 18:21
 * @describe 描述
 */
@Component
public class ColorFactoryBean implements FactoryBean {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
