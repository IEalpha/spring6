package com.icbc.sd.banktx.service.impl;

import com.icbc.sd.banktx.dao.AccountDao;
import com.icbc.sd.banktx.model.Account;
import com.icbc.sd.banktx.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl2 implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl2.class);

    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String from, String to, String amount) {
        Account fromAccount = accountDao.selectAccount(from);
        BigDecimal fromBalance = new BigDecimal(fromAccount.getBalance());
        BigDecimal transferAmount = new BigDecimal(amount);
        if (fromBalance.compareTo(transferAmount) < 0) {
            throw new RuntimeException("Insufficient balance, please contact the bank for help.");
        }
        Account toAccount = accountDao.selectAccount(to);
        BigDecimal toBalance = new BigDecimal(toAccount.getBalance());
        Integer count = accountDao.changeBalance(from, fromBalance.subtract(transferAmount).toString());
//        int i = 1 / 0;
        count += accountDao.changeBalance(to, toBalance.add(transferAmount).toString());
        if (count != 2) {
            throw new RuntimeException("Transfer failed, please contact the bank for help.");
        }
        System.out.println("Transfer succeeded.");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAccount(String name, String amount) {
        Integer i = accountDao.saveAccount(name);
        if (i == 1) {
            logger.info("Account saved: " + name);
            int deposit = 0;
//            try {
                deposit = deposit("刘涵旭", amount);
//            } catch (Exception e) {
//
//            }
            if (deposit == 1) {
                logger.info("Deposit succeeded: " + name + ", amount: " + amount);
            } else {
                logger.error("Failed to deposit: " + name);
            }
        } else {
            logger.error("Failed to save account: " + name);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int deposit(String name, String amount) {
        Account account = accountDao.selectAccount(name);
        BigDecimal balance = new BigDecimal(account.getBalance());
        BigDecimal depositAmount = new BigDecimal(amount);
        BigDecimal newBalance = balance.add(depositAmount);
        Integer j = accountDao.changeBalance(name, newBalance.toString());
        int i = 1 / 0;
        return j;
    }
}
