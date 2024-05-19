package com.icbc.sd.mybatis.test;

import com.icbc.sd.mybatis.config.JavaConfig;
import com.icbc.sd.mybatis.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountServiceTest {

    @Test
    void TestTransfer() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        AccountService accountService = annotationConfigApplicationContext.getBean(AccountService.class);
        accountService.transfer("liuhanxu","zhangyuning","10000");
    }
}
