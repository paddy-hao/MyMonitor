# MyMonitor
MyMonitorBackend服务端主要在TestController里面提供接口来接收客户端发送的数据，并存储在数据库。使用WebSocket与安卓客户端进行通信，但是存在一些问题，无法使用。在application.yml里数据库配置需要更改。

数据库表：CREATE TABLE `Resources` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `record_timestamp` varchar(255) NOT NULL DEFAULT '',
  `CPUFreq` json DEFAULT NULL,
  `downLoad` decimal(10,2) DEFAULT NULL,
  `upLoad` decimal(10,2) DEFAULT NULL,
  `FPS` decimal(5,2) DEFAULT NULL,
  `CPUUsage` decimal(5,2) DEFAULT NULL,
  `Latitude` decimal(10,6) DEFAULT NULL,
  `Longitude` decimal(10,6) DEFAULT NULL,
  `MemoryUsage` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

MyMonitor是安卓客户端使用androidstudio可以部署在模拟器或者手机上，手机需要打开开发者模式，使用数据线连接。
- 在SendResourceDataTask类中需要将服务端的IP地址进行更改。

MyMonitor2是Linux客户端，使用springboot开发的项目，内嵌了tomcat服务器，在MoniotrController里提供了访问接口，可以访问获取动态资源，和存储在text文件里的静态资源。

- 在docker中进行测试 ：
  docker rm -f my_monitor_container 
  docker rmi -f my_monitor
  mvn clean install
  docker build -t my_monitor .
  docker run -d -p 8080:8080 --name my_monitor_container my_monitor

使用如下docker
-<img width="705" alt="Screen Shot 2023-09-17 at 2 02 44 PM" src="https://github.com/paddy-hao/MyMonitor/assets/67146392/b2f72d7f-f321-4f4f-b9c9-e9a0403b6da7">

MyMonitorIOS是IOS客户端使用Xcode部署在模拟器上，在UnifiedMonitor中需要修改发送函数里的服务端IP地址
