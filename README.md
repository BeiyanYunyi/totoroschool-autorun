# 🏃‍ totoroschool / 龙猫校园半自动跑

> 古典时代的人发现人体是权力的对象和目标。……这种人体是被操纵、被塑造、被规训的。它服从，配合，变得灵巧、强壮。“人是机器”这部大书是在两个领域被同时撰写的。
> —— 米歇尔·福柯《规训与惩罚》

## ✅ 运行要求

- iOS 设备或已 root 的 Android 设备
- 一台个人电脑或服务器，Windows / Linux / MacOS 均可
- （可选）一个无线路由器

## 📋 安装运行时与依赖

这一步在你的电脑或服务器上进行。如果在以下任何一步卡住了，请翻墙。

首先，你需要到[Node.js 官网](https://nodejs.org/zh-cn/)下载 Node.js，长期维护版和尝鲜版都无所谓。Windows 下载下来是 .msi 格式的包，双击装上就行。如果是 Linux 系统系统，使用 apt/rpm/pacman 之类的包管理器安装就行了。Mac 像 windows 那样从官网下应该也行。

下载下来之后，你还需要进行如下操作：

- Windows 用户右键开始按钮-Windows Powershell（管理员）：

  ```powershell
  npm install -g yarn
  ```

- Linux 用户在终端中输入

  ```bash
  sudo npm install -g yarn
  ```

然后 clone 本项目，终端进入该文件夹中，输入 `yarn`，回车执行来安装依赖。

## 🦹‍♀️ DNS 劫持

### ❓ 原因

前置知识：DNS 服务器的作用是把域名解析为 ip 地址。

龙猫会向 app.xtotoro.com 发送相关请求。所以，我们需要自定义一个 DNS，把这个域名解析到自己电脑的 ip。这样我们的 fk-totoro 才能截获请求并进行修改等后续操作。

### 🔧 简略操作

如何自定义一个 DNS 呢？我们有三个方法：

1. 在 linux 电脑/服务器上运行 dnsmasq。
2. 在路由器上指定静态路由。
3. iOS 设备在美区 App Store 下载 shadowrocket 并进行设置。

这里不展开。值得注意的是，若使用第一种方法，则还需在设置-无线局域网-i-配置 DNS 中进行指定。

事成以后，在自己的电脑上进入 fk-totoro 文件夹，终端中输入`yarn dev`启动服务端，此时用你的 iOS 设备打开 `https://app.xtotoro.com` 应该会出现这样的一行字：“欢迎使用艹猫校园”。

## 📜 证书安装

### ❓ 为什么

龙猫校园使用了 https 通信，这是一种加密通信，为了获取其中的内容，我们需要安装证书。这也是未 root 的 Android 设备被拒之门外的原因。

在完成 DNS 劫持后，安装证书的方法如下：

1. 在自己的电脑上进入 fk-totoro 文件夹，终端中输入`yarn dev`启动服务端。
2. 在 safari 浏览器中输入以下网址并打开：`https://app.xtotoro.com/certs/pub.crt` 可能会提示“正在访问不安全网址”之类的，请通过之。
3. 会显示这么一个对话框：“此网站正尝试下载一个配置描述文件。您要允许吗？”，请点击“允许”，然后退出浏览器，打开设置。
4. 设置-通用-VPN 与设备管理中，在“已下载的描述文件”中找到 app.xtotoro.com 一项，点开，然后点“安装”。会提示你输密码验证，输入锁屏密码即可。

## 🐱 艹猫

经过了如上步骤，你已经完成配置，此后每次跑步执行以下操作即可：

1. 在自己的电脑上进入 fk-totoro 文件夹，终端中输入 `yarn dev` 启动服务端。
2. 打开龙猫校园并登录，观察界面的变化。大标题应该有“破解成功”字样。
3. 进入阳光跑，回到桌面，等待十分钟后再打开龙猫，查看自己的记录。

## 🏭 艹猫服务

你也可以开一个服务器，安装完运行时和依赖后，进行如下操作：

1. 搞个 dnsmasq，将 app.xtotoro.com 解析到这台服务器的 ip。
2. 重命名 fk-totoro/config/userConfig.example.json 为 userConfig.json，在里面加上你自己和你希望能使用这个服务的人的名字。
3. 使用 `yarn dev -s` 启动服务端。
4. 在需要跑龙猫的设备上完成 DNS 劫持和证书安装。
5. 每次跑步时，进行艹猫的 2、3 步。

### 🐋 Docker

如果你有 Docker 环境和经验，可以参考以下步骤：

首先想办法将 app.xtotoro.com 解析到这台服务器的 ip。然后参考这些命令：

```bash
mkdir /var/fk-totoro
cd /var/fk-totoro
mkdir config
wget https://raw.githubusercontent.com/lixiang810/totoroschool-autorun/main/config/userConfig.example.json -O config/userConfig.json
nano config/userConfig.json # 编辑白名单，在其中加入你自己的名字
wget https://raw.githubusercontent.com/lixiang810/totoroschool-autorun/main/docker-compose.yml
docker compose up -d
```

这以后，艹猫服务会监听 443 端口，并且提供 https 服务。如果需要反代（禁用艹猫自己的 https），那么请在`docker compose up -d`之前修改 docker-compose.yml，将以下两行注释掉：

```yaml
environment:
  - HTTPS=true
```
