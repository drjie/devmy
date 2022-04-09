package com.lz.service.impl;

import com.lz.dao.AccountDao;
import com.lz.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Override
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.decreaseMoney(from,money);

        accountDao.increaseMoney(to,money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
