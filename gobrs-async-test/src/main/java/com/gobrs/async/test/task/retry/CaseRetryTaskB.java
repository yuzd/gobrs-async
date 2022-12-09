package com.gobrs.async.test.task.retry;

import com.gobrs.async.core.TaskSupport;
import com.gobrs.async.core.anno.Task;
import com.gobrs.async.core.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: gobrs-async
 * @ClassName GobrsTaskA
 * @description:
 * @author: sizegang
 * @create: 2022-10-31
 **/
@Slf4j
@Task(retryCount = 4)
public class CaseRetryTaskB extends AsyncTask {

    @Override
    public void prepare(Object o) {
        log.info(this.getName() + " 使用线程---" + Thread.currentThread().getName());
    }

    @Override
    public Object task(Object o, TaskSupport support) {
        System.out.println("CaseRetryTaskB Begin");
        System.out.println(1 / 0);
        System.out.println("CaseRetryTaskB End");
        return "AResult";
    }
}
