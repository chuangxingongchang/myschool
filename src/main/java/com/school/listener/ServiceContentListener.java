package com.school.listener;

import com.school.util.TimeIntevalExecuteTaskService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.*;

/**
 * 监听器
 */
@WebListener
public class ServiceContentListener implements ServletContextListener {
    @Autowired
    TimeIntevalExecuteTaskService timeIntevalExecuteTaskService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1当服务器启动时候设置 一个定时器 循环执行
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //2定时创建一个线程 去执行任务
        //1.执行任务 2.首次执行延迟时间 3.定时执行时间 4.单位/秒
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                timeIntevalExecuteTaskService.addPushArticle();


            }

            },3600,3600, TimeUnit.SECONDS);

        //执行完成后关闭线程

    }

}
