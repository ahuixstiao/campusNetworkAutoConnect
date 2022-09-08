# 工程简介
    工程为自动化科师校园网认证的一个小工具，用springboot写的一个小工具，搭配上docker容器的一键部署，全平台可用。

# IDEA连接Docker来一键部署SpringBoot项目

#### 1、先将项目通过maven或gradle打包成jar，并切换到jar所在的目录下.

#### 2、配置Docker并连接.

- ![CleanShot%202022-09-03%20at%2016.52.06@2x](http://www.huichat.icu/upload/2022/09/CleanShot%202022-09-03%20at%2016.52.06@2x.png)

- #### 创建并配置Dockerfile文件

- ![CleanShot%202022-09-03%20at%2016.53.55@2x](http://www.huichat.icu/upload/2022/09/CleanShot%202022-09-03%20at%2016.53.55@2x.png)

- #### 在Run/Debug Configurations中点击加号配置Dockerfile启动器

- ![image-20220903165632981](http://www.huichat.icu/upload/2022/09/image-20220903165632981.png)

#### 最后点击运行Dockerfile启动器即可，如果运行失败一般是Dockerfile写错了可以百度一下写法.

![CleanShot%202022-09-03%20at%2017.03.37@2x](http://www.huichat.icu/upload/2022/09/CleanShot%202022-09-03%20at%2017.03.37@2x.png)
