package com.example.demo.netty.splitpackage;

import lombok.Data;

@Data
public class MessageWarp {

    private int length;

    private byte[] content;
}
