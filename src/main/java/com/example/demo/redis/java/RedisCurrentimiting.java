package com.example.demo.redis.java;

import com.example.demo.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.UUID;

public class RedisCurrentimiting {

    private Long intervalTime = 60 * 1000l;

    @Autowired
    private RedisTemplate redisTemplate;

    public ResponseResult limitFlow() {
        Long currentTime = new Date().getTime();
        System.out.println(currentTime);
        if (redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore("limit", currentTime - intervalTime, currentTime).size();        // intervalTime是限流的时间
            System.out.println(count);
            if (count != null && count > 5) {
                return ResponseResult.ok("每分钟最多只能访问5次");
            }
        }
        redisTemplate.opsForZSet().add("limit", UUID.randomUUID().toString(), currentTime);
        return ResponseResult.ok("访问成功");
    }

    // 输出令牌
    public ResponseResult limitFlow2(Long id) {
        Object result = redisTemplate.opsForList().leftPop("limit_list");
        if (result == null) {
            return ResponseResult.ok("当前令牌桶中无令牌");
        }
        return ResponseResult.ok("访问成功");
    }

}
