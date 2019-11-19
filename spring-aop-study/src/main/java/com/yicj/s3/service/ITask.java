package com.yicj.s3.service;

import com.yicj.s3.entity.TaskExecutionContent;

public interface ITask {
    void execute(TaskExecutionContent ctx) ;
}
