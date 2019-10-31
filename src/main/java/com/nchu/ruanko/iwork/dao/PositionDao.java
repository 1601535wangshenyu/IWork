package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.PoliticsStatus;
import com.nchu.ruanko.iwork.domain.entity.Position;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PositionDao {
    @Results(id = "positionMapper1", value = {
            @Result(property = "positionUId", column = "p_uid"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "createDate", column = "p_createDate"),
            @Result(property = "enabled", column = "p_enabled")
    })
    @Select("SELECT *" +
            " FROM i_tb_position" +
            " WHERE p_uid=#{uid}")
    Position getNationByNationUid(@Param(value = "uid") String positionUid);
}
