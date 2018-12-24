package schedule.tasks.demo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Title: schedule-tasks
 * @Description: TODO
 * @author: Administrator
 * @date: 2018-12-20 15:58
 * @version: 1.0.0
 */
public class Task implements Runnable {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private int i = 0;

    public Task(int i) {
        this.i = i;
    }

    public static void main(String[] args) {

        Task task = new Task(1);
        Task task1 = new Task(2);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        //第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(task, 2, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.scheduleAtFixedRate(task1, 2, 1, TimeUnit.SECONDS);


        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    System.out.println("shutdownNow !!");
                    service.shutdownNow();
                })
        );

        /*try {
            Thread.sleep(5);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }*/
    }


    @Override
    public void run()  {
        System.out.println(Thread.currentThread().getId() + "-Hello !!" + i + ":" + dateFormat.format(new Date()));
        try {
            throw new Exception("exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
