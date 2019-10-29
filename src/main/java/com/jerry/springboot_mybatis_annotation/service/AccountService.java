package com.jerry.springboot_mybatis_annotation.service;

import com.jerry.springboot_mybatis_annotation.dao.AccountMapper;
import com.jerry.springboot_mybatis_annotation.entity.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    public void transfer() throws RuntimeException {
        accountMapper.update1(90,1);
        int i=1/0;
        accountMapper.update1(110,2);
    }

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
