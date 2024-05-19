package com.icbc.sd.mybatis.service.impl;

import com.icbc.sd.mybatis.mapper.AccountMapper;
import com.icbc.sd.mybatis.model.Account;
import com.icbc.sd.mybatis.service.AccountService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void transfer(String from, String to, String amount) {
        Account fromAccount = accountMapper.selectByAccno(from);
        Account toAccount = accountMapper.selectByAccno(to);
        if (fromAccount == null || toAccount == null) {
            throw new RuntimeException("账户不存在");
        }
        BigDecimal fromBalance = new BigDecimal(fromAccount.getBalance());
        BigDecimal amountDecimal = new BigDecimal(amount);
        if (fromBalance.compareTo(amountDecimal) < 0) {
            throw new RuntimeException("余额不足");
        }
        BigDecimal newFromBalance = fromBalance.subtract(amountDecimal);
        BigDecimal toBalance = new BigDecimal(toAccount.getBalance());
        BigDecimal newToBalance = toBalance.add(amountDecimal);
        fromAccount.setBalance(newFromBalance.toString());
        toAccount.setBalance(newToBalance.toString());
        int i = accountMapper.updateByPrimaryKey(fromAccount);
        if (i != 2) {
            throw new RuntimeException("转账失败");
        }
        logger.info("转账成功");
    }
}
