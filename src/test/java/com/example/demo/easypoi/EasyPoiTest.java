package com.example.demo.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.easypoi.po.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EasyPoiTest {
    //查询所有记录 模拟数据库
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setAge(10+i);
            user.setName("小黄"+i);
            user.setBir(new Date());
            user.setHobby(Arrays.asList("烫头，抽烟"));
            users.add(user);
        }
        return users;
    }
    //导出Excel
    @Test
    public void testExport() throws IOException {
        //获取数据
        List<User> users = getUsers();
        //导出Excel
        //参数1、exportParams 导出配置对象， 参数2导出的类型，参数3 导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        //将excel写入指定位置
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("/Users/zhangchengfeng01/Downloads/cc.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputStream.close();
        workbook.close();


    }

}
