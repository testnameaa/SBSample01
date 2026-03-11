package com.example.doma2test.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface DenpyoDao {

    @Select
    String getNextDenNo();
}
