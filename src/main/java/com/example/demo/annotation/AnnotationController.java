package com.example.demo.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AnnotationController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 注：如果参数前写了@RequestParam(xxx)，那么前端必须有对应的xxx名字才行(不管其是否有值，当然可以通过设置该注解的required属性来调节是否必须传)，如果没有xxx名的话，那么请求会出错，报400。
     *
     * 注：如果参数前不写@RequestParam(xxx)的话，那么就前端可以有可以没有对应的xxx名字才行，如果有xxx名的话，那么就会自动匹配；没有的话，请求也能正确发送。
     *
     * 追注：这里与feign消费服务时不同；feign消费服务时，如果参数前什么也不写，那么会被默认是@RequestBody的。
     *
     * 当同时使用@RequestParam（）和@RequestBody时，@RequestParam（）指定的参数可以是普通元素、数组、集合、对象等等
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> getUserLogin(String name , @RequestParam("password") String password){
        if(StringUtils.isBlank(name)){
            name = "lisi";
        }
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM user where name = ? and password = ?", name, password);
        return list.get(0);
    }
}
