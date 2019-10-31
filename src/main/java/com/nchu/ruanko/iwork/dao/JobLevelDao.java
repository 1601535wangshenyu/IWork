package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.JobLevel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface JobLevelDao {
    @Results(id = "jobLevelMapper1", value = {
            @Result(property = "JobLevelUid", column = "j_uid"),
            @Result(property = "name", column = "j_name"),
            @Result(property = "titleLevel", column = "j_titleLevel"),
            @Result(property = "createDate", column = "j_createDate"),
            @Result(property = "enabled", column = "j_enabled")
    })
    @Select("SELECT *" +
            " FROM i_tb_joblevel" +
            " WHERE j_uid=#{uid}")
    JobLevel getJobLevelByJobLevelUid(@Param(value = "uid") String jobLevelUid);
}
