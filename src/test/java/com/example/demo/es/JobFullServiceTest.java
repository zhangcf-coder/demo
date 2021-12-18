package com.example.demo.es;

import com.example.demo.es.entity.JobDetail;
import com.example.demo.es.service.JobFullTextService;
import com.example.demo.es.service.impl.JobFullTextServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobFullServiceTest {

    private JobFullTextService jobFullTextService;

    @BeforeEach
    public void beforeTest() {
        jobFullTextService = new JobFullTextServiceImpl();
    }

    @Test
    public void addTest() throws IOException {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setId(4);
        jobDetail.setArea("北京666");
        jobDetail.setCmp("清华大学");
        jobDetail.setEdu("本科及以上");
        jobDetail.setExp("五年工作经验");
        jobDetail.setTitle("java架构师");
        jobDetail.setJob_type("全职");
        jobDetail.setPv("3000次浏览");
        jobDetail.setJd("Java架构");
        jobDetail.setSalary("60K/月");
        jobDetail.setAge(30);
        jobFullTextService.add(jobDetail);
    }

    @Test
    public void getTest() throws IOException {
        System.out.println(jobFullTextService.findById(4));
    }

    @Test
    public void updateTest() throws IOException {
        JobDetail jobDetail = jobFullTextService.findById(4);
        jobDetail.setTitle("java高级架构师");

        jobFullTextService.update(jobDetail);
    }

    @Test
    public void deleteTest() throws IOException {
        jobFullTextService.deleteById(4);
    }

    @Test
    public void searchTest() throws IOException {
        List<JobDetail> jobDetailList = jobFullTextService.searchByKeywords("java架构");
        for (JobDetail jobDetail : jobDetailList) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void searchByPageTest() throws IOException {
        Map<String, Object> resultMap = jobFullTextService.searchByPage("大数据", 1, 3);
        System.out.println("一共查询到:" + resultMap.get("total").toString());

        ArrayList<JobDetail> content = (ArrayList<JobDetail>)resultMap.get("content");
        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void searchByScrollPageTest1() throws IOException {
        Map<String, Object> resultMap = jobFullTextService.searchByScrollPage("大数据", null, 10);
        System.out.println("scroll_id:" + resultMap.get("scroll_id").toString());

        ArrayList<JobDetail> content = (ArrayList<JobDetail>)resultMap.get("content");
        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void searchByScrollPageTest2() throws IOException {
        Map<String, Object> resultMap = jobFullTextService.searchByScrollPage("spark", "DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAA0WZnFzaHFzaXZSQ0d2YW1UeGxBRC05dw==", 10);
        System.out.println("scroll_id:" + resultMap.get("scroll_id").toString());

        ArrayList<JobDetail> content = (ArrayList<JobDetail>)resultMap.get("content");
        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }
    }



    @AfterTest
    public void afterTest() throws IOException {
        jobFullTextService.close();
    }
}
