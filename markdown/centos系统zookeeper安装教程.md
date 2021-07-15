# centos系统zookeeper安装教程
## 1、安装前准备
![image-20210709144009112](C:\Users\Lee\AppData\Roaming\Typora\typora-user-images\image-20210709144009112.png)
安装前确认已经安装过jdk，且jdk不低于1.8 u211版本
## 2、官网下载
官网地址：https://zookeeper.apache.org/
3.7版本下载地址：https://www.apache.org/dyn/closer.lua/zookeeper/zookeeper-3.7.0/apache-zookeeper-3.7.0-bin.tar.gz
### 2.1、联网下载
```bash
# 直接使用命令下载
wget https://mirrors.bfsu.edu.cn/apache/zookeeper/zookeeper-3.7.0/apache-zookeeper-3.7.0-bin.tar.gz
# 解压缩
tar -zxvf apache-zookeeper-3.7.0-bin.tar.gz
# 移动到安装目录
mv apache-zookeeper-3.7.0-bin /usr/local/app
cd /usr/local/app
mv apache-zookeeper-3.7.0-bin zookeeper-3.7.0
```
### 2.2、下载后上传至指定文件夹
## 3、修改环境变量
```bash
vim /etc/profile
# 末尾位置添加如下内容
export ZOOKEEPER_HOME=/usr/local/app/zookeeper-3.7.0
export PATH=$PATH:$ZOOKEEPER_HOME/bin
# 保存
:wq
# 配置生效
source /etc/profile
```
## 4、修改zoo.cfg
```bash
# 打开配置目录
cd /usr/local/app/zookeeper-3.7.0/conf
# 将zoo_simple.cfg改名为zoo.cfg
mv zoo_sample.cfg zoo.cfg
# 修改配置
vim zoo.cfg
# 修改配置项 （快照日志目录，必须）
dataDir=/usr/local/zookeeper-3.4.11/dataDir
# 添加配置项 （事务日志目录，不配会和快照日志共享）
dataLogDir=/usr/local/zookeeper-3.4.11/dataLogDir
# 保存退出后，创建目录
mkdir dataDir
mkdir dataLogDir
```
## 5、Zookeeper启动与客户端连接
```bash
# 服务管理命令：
zkServer.sh start|stop|restart|status
# 客户端连接：
zkCli.sh -server ${ip}:${port}
#客户端关闭：
quit #或者按 Ctrl + C
```
## 6、注意
### 6.1
Error: Could not find or load main class org.apache.zookeeper.server.quorum.QuorumPeerMain
解决方案
因为在安装时，选用了 apache-zookeeper-{version}.tar.gz 包而不是 apache-zookeeper-{version}-bin.tar.gz 包，后面使用 apache-zookeeper-{version}-bin.tar.gz （文件名包含bin）重新安装后，可以解决问题。

### 6.2
Problem starting AdminServer on address 0.0.0.0, port 8080 and command URL /commands
解决方案
8080端口确实被占用， 可在zoo.cfg中配置admin.serverPort=8081修改端口