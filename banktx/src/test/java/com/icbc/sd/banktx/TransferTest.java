package com.icbc.sd.banktx;

import com.icbc.sd.banktx.config.ApplicationConfig;
import com.icbc.sd.banktx.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransferTest {

    @Test
    void testTransfer() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.transfer("刘涵旭", "张雨凝", "500.53");
    }

    @Test
    void testPropagation() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService accountService = ctx.getBean("accountServiceImpl", AccountService.class);
        accountService.saveAccount("大帅逼", "1000.00");
    }
}
