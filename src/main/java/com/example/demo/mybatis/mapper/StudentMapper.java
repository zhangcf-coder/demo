package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
}