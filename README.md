<p align="center">
	<img alt="logo" src="https://s1.ax1x.com/2022/12/07/zc5FVf.png" width="150">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">APIShield v0.0.1-rc.1</h1>
<h4 align="center">一个解决 WebAPI 在应用层面通讯安全相关问题的轻量级 JAVA 框架，让请求响应数据变得安全、优雅！</h4>
<p align="center">
    <a href='https://gitee.com/liupeiqiang/APIShield/stargazers'><img src='https://gitee.com/liupeiqiang/APIShield/badge/star.svg?theme=dark' alt='star'/></a>	
    <a href='https://gitee.com/liupeiqiang/APIShield/members'><img src='https://gitee.com/liupeiqiang/APIShield/badge/fork.svg?theme=gray' alt='fork'></img></a>	
    <a href="https://github.com/Coder-Xiaoyi/APIShield/stargazers"><img src="https://img.shields.io/github/stars/Coder-Xiaoyi/APIShield?style=flat-square&logo=GitHub"></a>
	<a href="https://github.com/Coder-Xiaoyi/APIShield/network/members"><img src="https://img.shields.io/github/forks/Coder-Xiaoyi/APIShield?style=flat-square&logo=GitHub"></a>
	<a href="https://github.com/Coder-Xiaoyi/APIShield/watchers"><img src="https://img.shields.io/github/watchers/Coder-Xiaoyi/APIShield?style=flat-square&logo=GitHub"></a>
	<a href="https://github.com/Coder-Xiaoyi/APIShield/issues"><img src="https://img.shields.io/github/issues/Coder-Xiaoyi/APIShield.svg?style=flat-square&logo=GitHub"></a>
	<a href="https://github.com/Coder-Xiaoyi/APIShield/blob/master/LICENSE"><img src="https://img.shields.io/github/license/Coder-Xiaoyi/APIShield.svg?style=flat-square"></a>
</p>

---

## 前言：
- [在线文档：https://apishield.xystudio.top](https://apishield.xystudio.top)

- 注：学习测试请拉取 master 分支，dev 为正在开发的分支，有很多特性并不稳定。

- 开源不易，点个 star 鼓励一下吧！


## APIShield 介绍

APIShield (又名：API盾) 是一款集成各种 WebAPI 安全策略方案的轻量级 JAVA 框架，免于在设计复杂的系统中因 WebAPI 的安全问题而焦头烂额。并且它还提供了一整套前后端 WebAPI 响应或请求的解决方案，只需要简单配置您即可信手拈来。

APIShield 旨在以简单、优雅的方式完成系统接口安全校验或加解密部分，以最常用的MD5摘要签名校验为例，您只需要将注解放在对应方法或类上即可使用。

下面是一个最基本的示例：

```java
// SpringBoot 示例
@RestController
@RequestMapping("/api")
@ApiShieldUserAgent(value = {UA.DEV_WECHAT}, forbids = {UA.DEV_MOBILE})
public class ApiController {

    @GetMapping("/queryStu")
    @ApiShieldCheckTimestamp
    @ApiShieldDigestSignature
    public String queryStudent(Student stu){
        return "success";
    }
}
```

```bash
# 微信PC端请求接口-QueryString携带Sign 成功示例
> curl http://127.0.0.1/api/queryStu?name=张三&age=18&apishield-ts=1670945512652&apishield-sign=99d35676c36acac696f0a424dcf34ca1
success
```

## 交流群
微信交流群：

<img src="https://s1.ax1x.com/2022/12/20/zLJWjA.md.png" width="255">

(扫码添加微信，备注：apishield，邀您加入群聊)

<br>