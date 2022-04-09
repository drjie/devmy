package com.lz.dao;

import com.lz.entity.Account;
import com.lz.entity.TAccount;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    Account findById(Integer id);
    List<TAccount> findByCamelCase();
}
