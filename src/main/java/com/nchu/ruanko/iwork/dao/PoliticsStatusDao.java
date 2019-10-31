package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Nation;
import com.nchu.ruanko.iwork.domain.entity.PoliticsStatus;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PoliticsStatusDao {
    @Results(id = "politicsStatusMapper1", value = {
            @Result(property = "politicsStatusUId", column = "p_id"),
            @Result(property = "name", column = "p_name")
    })
    @Select("SELECT *" +
            " FROM i_tb_politicsstatus" +
            " WHERE p_id=#{uid}")
    PoliticsStatus getNationByNationUid(@Param(value = "uid") String politicsStatusUid);
}
