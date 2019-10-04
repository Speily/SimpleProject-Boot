package com.speily.service;

import com.speily.entity.Job;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author spl
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, Job job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}
