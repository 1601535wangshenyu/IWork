package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.JobLevel;
import com.nchu.ruanko.iwork.domain.entity.Nation;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NationDao {
    @Results(id = "nationMapper1", value = {
            @Result(property = "nationUid", column = "n_id"),
            @Result(property = "name", column = "n_name")
    })
    @Select("SELECT *" +
            " FROM i_tb_nation" +
            " WHERE n_id=#{uid}")
    Nation getNationByNationUid(@Param(value = "uid") String nationUid);
}
