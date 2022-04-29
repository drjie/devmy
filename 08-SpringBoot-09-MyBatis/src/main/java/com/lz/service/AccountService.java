package com.lz.service;

public interface AccountService {
    // 转账
    void transferMoney(Integer from, Integer to, Integer money);
}
