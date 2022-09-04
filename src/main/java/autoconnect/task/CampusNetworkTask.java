package autoconnect.task;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ahui
 * @Description: 任务类
 * @DateTime: 2022/9/3 - 09:59
 **/
@Slf4j
@Component
public class CampusNetworkTask {

    private final TaskEntity task;

    @Autowired
    private CampusNetworkTask (TaskEntity taskEntity) {
        this.task = taskEntity;
    }

    public void taskContent() {
        Map<String, Object> map = new HashMap<>(20);
        map.put("loginType", null);
        map.put("auth_type", task.getAuth_type());
        map.put("isBindMac1", task.getIsBindMac1());
        map.put("pageid", task.getPageid());
        map.put("templatetype", task.getTemplatetype());
        map.put("listbindmac", task.getListbindmac());
        map.put("recordmac", task.getRecordmac());
        map.put("isRemind", task.getIsRemind());
        map.put("loginTimes", null);
        map.put("groupId", null);
        map.put("distoken", null);
        map.put("echostr", null);
        map.put("url", task.getUrl());
        map.put("isautoauth", null);
        map.put("notice_pic_loop1", task.getNotice_pic_loop1());
        map.put("notice_pic_loop2", task.getNotice_pic_loop2());
        map.put("userId", task.getUserId());
        map.put("passwd", task.getPasswd());
        map.put("remInfo", task.getRemInfo());

        //发起请求去获取
        //解析页面判断是否成功
        Document document = Jsoup.parse(HttpUtil.post(task.getCampusUrl(), map));
        String connectStatus = document.getElementsByClass("common2").get(0).text();
        if(StrUtil.isBlank(connectStatus)) {
            log.info("运营商网络拨号失败");
        }else {
            log.info("运营商网络拨号成功");
        }
    }
}
