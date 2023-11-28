package com.cht.temsis.test;

import javax.annotation.Resource;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EncryptorTest {
    @Resource
    private StringEncryptor jasyptStringEncryptor;
 
    @Test
    public void encode() {
        //System.out.println( "加密密文：" + jasyptStringEncryptor.encrypt("Trevor242433") );
        //System.out.println("解密密文：" + jasyptStringEncryptor.decrypt("HOuO53YR2eAwzNQhz0LvvNdF3PnZKcpq"));
    }
}