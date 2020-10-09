package com.entity;

import com.condition.MyImportBeanDefinitionRegistrar;
import com.condition.MyImportSelector;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.beans.Transient;

/**
 * @author zyl
 * @date 2020/9/24 22:30
 * @describe 描述
 */
@Data
@Import({QuartzLogEntity.class, MyImportBeanDefinitionRegistrar.class})
@Component
public class QuartzJobEntity {

    public static final String JOB_KEY = "JOB_KEY";

    private Long id;

    private String uuid;

    private String jobName;

    private String beanName;

    private String methodName;

    private String params;

    private String cronExpression;

    private Boolean isPause = false;

    private String personInCharge;

    private String email;

    private String subTask;

    private Boolean pauseAfterFailure;

    private String description;
}
