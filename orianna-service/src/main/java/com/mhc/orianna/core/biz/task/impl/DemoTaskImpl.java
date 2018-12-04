package com.mhc.orianna.core.biz.task.impl;


import com.mhc.orianna.core.biz.task.DemoTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoTaskImpl implements DemoTask {

    @Override
    public void test() {
        //实现逻辑
        System.out.println("定时任务执行");
    }
}
