package com.icbc.sd.banktx.dao;

import com.icbc.sd.banktx.model.Account;
import org.springframework.stereotype.Repository;

public interface AccountDao {

    Account selectAccount(String name);

    Integer changeBalance(String name, String balance);

    Integer saveAccount(String name);

}
