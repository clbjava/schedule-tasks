package schedule.tasks.demo.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: schedule-tasks
 * @Description: TODO
 * @author: Administrator
 * @date: 2018-12-20 14:35
 * @version: 1.0.0
 */
@Configuration
public class SchedulingConfiguration implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        ThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, new ThreadFactory() {
            private AtomicInteger max = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable run) {
                return new Thread(run, "scheduling-" + max.incrementAndGet());
            }
        }
        );
        return scheduledThreadPoolExecutor;
    }
}
