package autoconnect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling //开启定时任务
@SpringBootApplication
public class CampusNetworkAutoConnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusNetworkAutoConnectApplication.class, args);
    }

}
