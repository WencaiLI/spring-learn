package com.lwc.mybatis.db.dao.generated;

import com.lwc.mybatis.db.genarated.model.Account;
import com.lwc.mybatis.db.genarated.model.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountDAO {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}