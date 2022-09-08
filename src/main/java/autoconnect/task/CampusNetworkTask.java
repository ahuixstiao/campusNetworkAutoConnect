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
import java.util.Objects;

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
    public CampusNetworkTask(TaskEntity taskEntity) {
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

        //发起请求去解析页面
        Document document = Jsoup.parse(HttpUtil.post(task.getCampusUrl(), map));
        try {
            //获取指定标签文本
            String online = Objects.requireNonNull(document.getElementById("online")).text();
            //判断是否成功进入到登录页面
            if (StrUtil.isNotBlank(online)) {
                log.info("运营商网络拨号成功");
            }
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
            //发生错误时打印返回的页面信息
            log.error(document.toString());
            //打印提示
            log.info("没有这个值，请查看页面的返回是否已经更改!");
            //失败重试.
            this.taskContent();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            indexOutOfBoundsException.printStackTrace();
            //发生错误时打印返回的页面信息
            log.error(document.toString());
            //打印提示
            log.info("网页中没有这标签，表示可能没能成功进入登录页面!");
            //失败重试.
            this.taskContent();
        }

    }
}
