package com.yicj.s3.service.impl;

import com.yicj.s3.entity.TaskExecutionContent;
import com.yicj.s3.service.ITask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockTask implements ITask {
    @Override
    public void execute(TaskExecutionContent ctx) {
        log.info("MockTask 的 task 执行.");
    }
}
