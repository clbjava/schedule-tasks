package schedule.tasks.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: schedule-tasks
 * @Description: TODO
 * @author: Administrator
 * @date: 2018-12-20 11:32
 * @version: 1.0.0
 */

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }


    @Scheduled(cron="0/6 * * * * *")
    public void cron() {
        log.info("cron the time is now {}", dateFormat.format(new Date()));
    }

}
