package top.xystudio.apishield.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.xystudio.apishield.ApiShieldManager;

/**
 * ApiShield 整合SpringBoot 示例
 * @author liupeiqiang
 * @date 2022/12/8 18:45
 */
@SpringBootApplication
public class ApiShieldDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiShieldDemoApplication.class, args);
        System.out.println("\n启动成功：Config 配置如下：" + ApiShieldManager.getConfig());
    }

}
