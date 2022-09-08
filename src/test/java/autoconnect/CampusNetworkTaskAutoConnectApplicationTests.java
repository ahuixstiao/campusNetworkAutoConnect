package autoconnect;

import autoconnect.task.CampusNetworkTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CampusNetworkTaskAutoConnectApplicationTests {

    @Autowired
    CampusNetworkTask campusNetworkTask;

    @Test
    void contextLoads() {
       campusNetworkTask.taskContent();
    }

}
