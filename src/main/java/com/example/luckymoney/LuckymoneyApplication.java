package com.example.luckymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *  @SpringBootApplication：
 *  包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解。
 *  其中@ComponentScan让springBoot扫描到Configuration类并把它加入到程序上下文。
 *
 *  spring boot应用程序的入口点是包含@SpringBootApplication注释和main方法的类。
 *  //更多请阅读：https://www.yiibai.com/spring-boot/spring_boot_introduction.html
 *
 *  自动配置Spring Boot Auto Configuration会根据在项目中添加的JAR依赖项自动配置Spring应用程序。例如，如果MySQL数据库在类路径上，但尚未配置任何数据库连接，则Spring Boot会自动配置内存数据库。
 *  为此，需要将@EnableAutoConfiguration批注或@SpringBootApplication批注添加到主类文件中。然后，将自动配置Spring Boot应用程序。
 *
 *
 * 浏览器输入：http://localhost:8080/hello
 * 输出 spring boot study
 *
 * 项目目录下maven启动项目
 * mvn spring-boot:run
 *
 * maven命令打包
 * mvn clean package
 *
 * mvn clean package -Dmaven.test.skip=true
 * 在E:\jinhui_workspace\workspace_web\luckymoney\target下生成
 * luckymoney-0.0.1-SNAPSHOT.jar
 *
 * 通过jar启动程序：
 * java -jar target/luckymoney-0.0.1-SNAPSHOT.jar
 *
 *
 * 加入配置类注解 @ConfigurationProperties 后 注解上出现红色下划线
 * Configuration Annotation Proessor not found in classpath 的错误
 *
 * 解决办法:
 * 1.在pom中加
 * <dependency>
 *    <groupId> org.springframework.boot </groupId>
 *    <artifactId>spring-boot-configuration-processor </artifactId>
 *    <optional> true </optional>
 * </dependency>
 *
 * 2.上面加上 @Component 就没有了额，报错了可以先看后面的
 *
 * dev下运行生产话环境
 * java -jar -Dspring.profiles.active=prod target/luckymoney-0.0.1-SNAPSHOT.jar
 *
 * 模板渲染：
 * 1.
 * <!--<dependency>-->
 *             <!--<groupId>org.springframework.boot</groupId>-->
 *             <!--<artifactId>spring-boot-starter-thymeleaf</artifactId>-->
 *         <!--</dependency>-->
 * 2. templates下创建index.html
 * 3. @Controller
 * public class HelloController {
 *
 *     @RequestMapping(value = "/hello", method = RequestMethod.GET)
 *     public String getMinMoney(){
 *         return "index";  // 使用模板
 *     }
 * }
 *
 * maven库：
 * https://mvnrepository.com/
 *
 */

@SpringBootApplication
public class LuckymoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckymoneyApplication.class, args);
    }

}
