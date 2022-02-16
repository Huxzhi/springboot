package com.huxzhi.springboot;

import org.junit.jupiter.api.Test;

import static com.huxzhi.springboot.Utils.JasyptEncryptorUtils.decode;
import static com.huxzhi.springboot.Utils.JasyptEncryptorUtils.encode;

public class MyTest {
    @Test
    public static void main(String[] args) {
        String encode = encode("jdbc:mysql://huxzhi.top:3306/floating-population?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8");
        decode(encode);
    }
}
