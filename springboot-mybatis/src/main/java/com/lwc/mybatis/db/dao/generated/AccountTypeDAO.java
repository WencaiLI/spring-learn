package com.lwc.mybatis.db.dao.generated;

import com.lwc.mybatis.db.genarated.model.AccountType;
import com.lwc.mybatis.db.genarated.model.AccountTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountTypeDAO {
    long countByExample(AccountTypeExample example);

    int deleteByExample(AccountTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountType record);

    int insertSelective(AccountType record);

    List<AccountType> selectByExample(AccountTypeExample example);

    AccountType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountType record, @Param("example") AccountTypeExample example);

    int updateByExample(@Param("record") AccountType record, @Param("example") AccountTypeExample example);

    int updateByPrimaryKeySelective(AccountType record);

    int updateByPrimaryKey(AccountType record);
}