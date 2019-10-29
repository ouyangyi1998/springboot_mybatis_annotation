package com.jerry.springboot_mybatis_annotation.dao;

import com.jerry.springboot_mybatis_annotation.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name")String name,@Param("money")double money);

    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    int update(@Param("name")String name,@Param("money")double money,@Param("id")int id);

    @Delete("delete from account where id=#{id}")
    int delete(int id);

    @Select("select id,name as name,money as money from account where id=#{id}")
    Account findAccount(@Param("id")int id);

    @Select("select id,name as name,money as money from account")
    List<Account> findAccountList();

    @Update("update account set money=#{money} where id=#{id}")
    void update1(@Param("money")double money,@Param("id")int id);
}
