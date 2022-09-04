package autoconnect.scheduled;

import autoconnect.task.CampusNetworkTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: ahui
 * @Description: 定时任务
 * @DateTime: 2022/9/4 - 07:42
 **/
@Slf4j
@Component
public class ScheduledTasks {

    private final CampusNetworkTask task;

    @Autowired
    private ScheduledTasks(CampusNetworkTask campusNetworkTask) {
        this.task = campusNetworkTask;
    }

    /**
     * 定时任务
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void execute() {
        //执行请求
        task.taskContent();
    }

}
