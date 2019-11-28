package com.yicj.s2.service.impl;

import com.yicj.s1.common.TaskExecutionContent;
import com.yicj.s2.service.ITask;

public class MockTask implements ITask {
    @Override
    public void execute(TaskExecutionContent content) {
        System.out.println("task executed .");
    }
}
