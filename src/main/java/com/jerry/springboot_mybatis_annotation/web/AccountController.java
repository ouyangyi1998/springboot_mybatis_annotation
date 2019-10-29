package com.jerry.springboot_mybatis_annotation.web;

import com.jerry.springboot_mybatis_annotation.entity.Account;
import com.jerry.springboot_mybatis_annotation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts()
    {
        return accountService.findAccountList();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String getAccount(@PathVariable("id")int id, @RequestParam("name")String name,@RequestParam("money")double money)
    {
        int t=accountService.update(name,money,id);
        if (t==1)
        {
            return "success";
        }else
        {
            return "fail";
        }
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id")int id)
    {
        return accountService.findAccount(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")int id)
    {
        int t=accountService.delete(id);
        if(t==1)
        {
            return "success";
        }else
        {
            return "fail";
        }
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam("name")String name,@RequestParam("money")double money )
    {
        int t=accountService.add(name,money);
        if(t==1)
        {
            return "success";
        }else
        {
            return "fail";
        }
    }
    @RequestMapping(value = "transfer",method = RequestMethod.GET)
    public void  transfer()
    {
        accountService.transfer();
    }

}
