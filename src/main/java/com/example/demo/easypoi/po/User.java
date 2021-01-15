package com.example.demo.easypoi.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ExcelTarget("users") //必须要实现序列化
public class User implements Serializable {
    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "年龄",orderNum="1",suffix = "岁")
    private Integer age;
    @Excel(name = "生日",width = 35.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
    @ExcelIgnore
    private List<String> hobby;
    @Excel(name = "爱好",width = 20.0,orderNum = "5")
    private String hobbys;
    @Excel(name = "头像",width = 20,type = 2)
    private String photo;

    public String getHobbys() {
        StringBuilder sb = new StringBuilder();
        hobby.forEach(e->{
            sb.append(e).append("、");
        });
        return sb.toString();
    }
}
