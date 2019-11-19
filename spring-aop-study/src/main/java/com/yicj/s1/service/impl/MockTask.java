package com.yicj.s1.service.impl;

import com.yicj.s1.TaskExecutionContent;
import com.yicj.s1.service.ITask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockTask implements ITask {
    @Override
    public void execute(TaskExecutionContent ctx) {
        log.info("MockTask 的 task 执行.");
    }
}
