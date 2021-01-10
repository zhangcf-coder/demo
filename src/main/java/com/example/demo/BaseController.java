package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    /**
     * 整合Thymeleaf
     * 步骤1 ：添加jar包
     * <dependency>
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-thymeleaf</artifactId>
     * </dependency>
     * 步骤2：添加必要的配置
     * 若是application.properties 添加如下配置
     * spring.thymeleaf.cache=false
     * spring.thymeleaf.encoding=UTF-8
     * spring.thymeleaf.enabled=true
     * spring.thymeleaf.mode=HTML
     * spring.thymeleaf.prefix=classpath:/templates/
     * spring.thymeleaf.suffix=.html
     * spring.thymeleaf.servlet.content-type=text/html
     * 若是application.yml 添加如下配置
     *   thymeleaf:
     *     cache: false
     *     encoding: UTF-8
     *     enabled: true
     *     mode: HTML
     *     prefix: classpath:/templates/
     *     suffix: .html
     *     servlet:
     *       content-type: text/html
     *  以上配置中除了第一个之外，其余皆可不配置，上面的值也是默认值，需要修改的时候再进行配置 当前代码是将配置信息放置到application.yml文件中
     *  步骤4：添加控制器和动态页面
     *  @Controller
     * public class BaseController {
     *     @RequestMapping("index")
     *     public String toIndex(ModelMap model){
     *         model.put("name","首页啊");
     *         return "index";
     *     }
     * }
     * 步骤5：创建index.html文件 resources/templates/index.html
     *<!Doctype html>
     * <html xmlns:th="http://www.w3.org/1999/xhtml">
     * <head>
     *     <title>下一页</title>
     * </head>
     * <body>
     * <h1 th:text="${name}">Hello World</h1>
     * </body>
     * </html>
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(ModelMap model){
        model.put("name","首页啊");
        return "index";
    }
}
