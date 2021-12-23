package com.example.demo.mq.rabbitmq.workqueue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SMS {
    private String name;
    private String mobile;
    private String content;
}
