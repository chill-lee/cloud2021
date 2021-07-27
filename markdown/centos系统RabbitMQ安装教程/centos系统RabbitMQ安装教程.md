# centos系统RabbitMQ安装教程
## 1、安装前准备

官网地址：www.rabbitmq.com
1.1、JDK1.8
1.2、Centos7-64位
1.3、Erlang-OTP 23
1.4、RabbitMQ-3.9.0
1.5、需要联网

## 2、安装Erlang

### 2.1、[erlang和rabbitmq的版本对应关系](https://www.rabbitmq.com/which-erlang.html)

<img src=".\image\image-20210727111410762.png" style="zoom:67%;" />

<img .\image\image-20210727111410762.png" alt="image-20210727111410762" style="zoom:75%;" />

### 2.2、通过rpm安装erlang

#### 2.2.1、[完成erlang的前置条件配置](https://packagecloud.io/rabbitmq/erlang/install#bash-rpm)

```bash
curl -s https://packagecloud.io/install/repositories/rabbitmq/erlang/script.rpm.sh | sudo bash
```

#### 2.2.2、安装erlang

```bash
yum install -y erlang
```

#### 2.2.3、检查erlang的版本号

```bash
erl
```

![image-20210727111852435](.\image\image-20210727111852435.png)

## 3、安装RabbitMQ

3.9.0版本下载地址：https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.9.0/rabbitmq-server-3.9.0-1.el7.noarch.rpm

### 3.1、导入key
```bash
rpm --import https://packagecloud.io/rabbitmq/rabbitmq-server/gpgkey
rpm --import https://packagecloud.io/gpg.key
rpm --import https://www.rabbitmq.com/rabbitmq-release-signing-key.asc
```
### 3.2、[完成RabbitMQ的前置条件配置](https://packagecloud.io/rabbitmq/rabbitmq-server/install#bash-rpm)
```bash
curl -s https://packagecloud.io/install/repositories/rabbitmq/rabbitmq-server/script.rpm.sh | sudo bash
```

### 3.3、下载RabbitMQ安装包

<img src=".\image\image-20210727112358018.png" alt="image-20210727112358018" style="zoom:67%;" />

### 3.4、下载成功后，上传到服务器，然后使用命名安装

```bash
rpm -ivh rabbitmq-server-3.9.0-1.el7.noarch
yum -y install epel-release
yum -y install socat
```

### 3.5、启用管理平台插件，启用插件后，可以可视化管理RabbitMQ

```bash
rabbitmq-plugins enable rabbitmq_management
```

### 3.6、启动RabbitMQ

```bash
systemctl start rabbitmq-server
systemctl enable rabbitmq-server
```

### 3.7、新建用户admin

RabbitMQ3.3以后，guest账号只能在本机登录

```bash
rabbitmqctl add_user admin admin
#设置admin为超级管理员
rabbitmqctl set_user_tags admin administrator
#授权远程访问（也可以登录后，可视化配置）
rabbitmqctl set_permissions -p / admin "." "." ".*"
#重启RabbitMQ
systemctl restart rabbitmq-server
```

### 3.8、登录用户admin

![image-20210727113205547](.\image\image-20210727113205547.png)

注意：注意：192.168.10.88是安装RabbitMQ的服务器IP地址。如果访问不了，确认是否开启端口5672和15672。开启方法参考：[Centos7防火墙常用基本命名](https://blog.csdn.net/weixin_40584261/article/details/106826961)

## 4、参考

4.1、https://blog.csdn.net/weixin_40584261/article/details/106826044

4.2、https://www.rabbitmq.com/install-rpm.html