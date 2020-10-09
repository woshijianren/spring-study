package com.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author zyl
 * @date 2020/9/24 22:31
 * @describe 描述
 */
@Data
public class QuartzLogEntity {

    private Long id;

    private String jobName;

    private String beanName;

    private String methodName;

    private String params;

    private String cronExpression;

    private Boolean isSuccess;

    private String exceptionDetail;

    private Long time;

    private Timestamp createTime;
}
