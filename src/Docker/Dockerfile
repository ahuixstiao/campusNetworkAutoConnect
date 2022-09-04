#指定镜像名称包括版本
FROM openjdk:11

#作者名称与邮箱
MAINTAINER ahui<ahuixst@qq.com>
#设置时区 防止容器内时间不对称导致定时任务不能按时执行.
RUN echo 'Asia/Shanghai' > /etc/timezone

VOLUME /tmp

#复制到docker容器中的路径 需要先将目录切换到target才能执行成功
ADD target/campusNetworkAutoConnect-0.0.1-SNAPSHOT.jar /app.jar

#容器启动时的运行的命令
ENTRYPOINT ["java", "-jar","/app.jar"]