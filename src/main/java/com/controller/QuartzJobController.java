package com.controller;

import com.business.QuartzTestBusiness;
import com.entity.QuartzJobEntity;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * @author zyl
 * @date 2020/9/24 22:28
 * @describe 描述
 */
@Controller
public class QuartzJobController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/add")
    public void addJob(String cronExpression) throws SchedulerException {
        if (!CronExpression.isValidExpression(cronExpression)) {
            throw new RuntimeException("cron表达式错误");
        }

        /**
         * addJob
         */
        JobDetail job = JobBuilder.newJob(QuartzTestBusiness.class).withIdentity("jobkey" + 1).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerkey" + 1).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).startNow().build();
        System.out.println(trigger.getKey().getName());
        System.out.println(trigger.getKey());
        scheduler.scheduleJob(job, trigger);
    }

    @GetMapping("/resume/{id}")
    public void resume(@PathVariable("id")Integer id) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("triggerkey" + id);
//        Trigger trigger = scheduler.getTrigger(triggerKey);
        JobKey jobKey = JobKey.jobKey("jobkey" + id);
        scheduler.resumeJob(jobKey);
    }

    @GetMapping("/stop/{id}")
    public void stomp(@PathVariable("id") Integer id) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("jobkey" + id);
        scheduler.pauseJob(jobKey);
    }

    @GetMapping("/update")
    public void update(@RequestBody QuartzJobEntity quartzJobEntity) throws SchedulerException {
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        for (String jobGroupName : jobGroupNames) {
            Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.groupEquals(jobGroupName));
            for (JobKey jobKey : jobKeys) {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                System.out.println("jobDetail.getKey() = " + jobDetail.getKey());
                List<? extends Trigger> triggersOfJob = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggersOfJob) {
                    TriggerKey key = trigger.getKey();
                    System.out.println("key.getGroup() = " + key.getGroup());
                    System.out.println("key.getName() = " + key.getName());
                }
            }
        }
        if (CronExpression.isValidExpression(quartzJobEntity.getCronExpression())) {
            TriggerKey triggerKey = TriggerKey.triggerKey("triggerkey" + quartzJobEntity.getId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(quartzJobEntity.getCronExpression());
//            trigger = trigger.getTriggerBuilder().withIdentity("key" + quartzJobEntity.getId()).withSchedule(cronSchedule).build();
            trigger = trigger.getTriggerBuilder().withIdentity("triggerkey" + quartzJobEntity.getId()).withSchedule(cronSchedule).build();

            scheduler.rescheduleJob(triggerKey, trigger);




        }
    }
}
