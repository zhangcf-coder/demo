package com.example.demo.mybatis;

import com.example.demo.mybatis.mapper.StudentMapper;
import com.example.demo.mybatis.po.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisTest {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 在pom.xml文件中导入三个整合mybatis所需的依赖jar包
     * <!-- mybatis整合springboot jar包 -->
     *         <dependency>
     *             <groupId>org.mybatis.spring.boot</groupId>
     *             <artifactId>mybatis-spring-boot-starter</artifactId>
     *             <version>1.3.2</version>
     *         </dependency>
     *
     *         <!-- driud整合springboot jar包 -->
     *         <dependency>
     *             <groupId>com.alibaba</groupId>
     *             <artifactId>druid-spring-boot-starter</artifactId>
     *             <version>1.1.10</version>
     *         </dependency>
     *
     *         <!-- mysql驱动 -->
     *         <dependency>
     *             <groupId>mysql</groupId>
     *             <artifactId>mysql-connector-java</artifactId>
     *             <version>5.1.47</version>
     *         </dependency>
     *  步骤2：在application.yml中配置druid连接池（只是简单配置）
     *  spring:
     *   datasource:
     *     druid:
     *       username: root
     *       password: root
     *       url: jdbc:mysql://49.232.211.149:3306/demo
     *       driver-class-name: com.mysql.jdbc.Driver
     *       type: com.alibaba.druid.pool.DruidDataSource
     *  步骤三：创建实体类
     *  package com.ph.springbootmybatis.entity;
     *
     * import lombok.Data;
     *
     * @Data
     * public class Student {
     *
     *     private long id;
     *     private String name;
     * }
     * 步骤四： 创建mapper接口
     *package com.example.demo.mybatis.mapper;
     *
     * import com.example.demo.mybatis.po.Student;
     * import org.apache.ibatis.annotations.Mapper;
     *
     * import java.util.List;
     *
     * @Mapper
     * public interface StudentMapper {
     *     List<Student> findAll();
     * }
     * 步骤五 创建mapper.xml文件
     * <?xml version="1.0" encoding="UTF-8" ?>
     * <!DOCTYPE mapper
     *         PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
     *         "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     * <mapper namespace="com.example.demo.mybatis.mapper.StudentMapper">
     *     <select id="findAll" resultType="com.example.demo.mybatis.po.Student">
     *         select * from student
     *     </select>
     * </mapper>
     * 步骤六 在application.yml中配置扫描映射文件
     * #配置mybatis
     * mybatis:
     *   #扫描xml文件
     *   mapper-locations: classpath:mapper/*.xml
     *   configuration:
     *     #开启驼峰命名法
     *     map-underscore-to-camel-case: true
     * 步骤七 测试
     * package com.example.demo.mybatis;
     *
     * import com.example.demo.mybatis.mapper.StudentMapper;
     * import com.example.demo.mybatis.po.Student;
     * import org.junit.jupiter.api.Test;
     * import org.springframework.beans.factory.annotation.Autowired;
     * import org.springframework.boot.test.context.SpringBootTest;
     *
     * import java.util.List;
     *
     * @SpringBootTest
     * public class MybatisTest {
     *
     *     @Autowired
     *     private StudentMapper studentMapper;
     *     @Test
     *     void findAll() {
     *         List<Student> students = studentMapper.findAll();
     *         for (Student student : students) {
     *             System.out.println(student);
     *         }
     *     }
     * }
     */
    @Test
    void findAll() {
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
