package autoconnect.task;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ahui
 * @Description: 实体类
 * @DateTime: 2022/9/4 - 06:56
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "task")
public class TaskEntity {

    @Value("${task.campusUrl}")
    private String campusUrl;
    @Value("${task.auth_type}")
    private Integer auth_type;
    @Value("${task.isBindMac1}")
    private Integer isBindMac1;
    @Value("${task.pageid}")
    private Integer pageid;
    @Value("${task.templatetype}")
    private Integer templatetype;
    @Value("${task.listbindmac}")
    private Integer listbindmac;
    @Value("${task.recordmac}")
    private Integer recordmac;
    @Value("${task.isRemind}")
    private Integer isRemind;
    @Value("${task.url}")
    private String url;
    @Value("${task.notice_pic_loop1}")
    private String notice_pic_loop1;
    @Value("${task.notice_pic_loop2}")
    private String notice_pic_loop2;
    @Value("${task.userId}")
    private String userId;
    @Value("${task.passwd}")
    private String passwd;
    @Value("${task.remInfo}")
    private String remInfo;

}
