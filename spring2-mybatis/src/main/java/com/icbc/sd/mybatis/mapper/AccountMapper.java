package com.icbc.sd.mybatis.mapper;

import com.icbc.sd.mybatis.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account row);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account row);

    Account selectByAccno(String accno);
}