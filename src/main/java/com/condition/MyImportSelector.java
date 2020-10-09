package com.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zyl
 * @date 2020/10/8 18:00
 * @describe 描述
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[] {"com.entity.QuartzLogEntity"};
    }
}
