package com.business;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * @author zyl
 * @date 2020/9/24 22:38
 * @describe 描述
 */
@Service
public class QuartzTestBusiness extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("我是test1");
    }
}
