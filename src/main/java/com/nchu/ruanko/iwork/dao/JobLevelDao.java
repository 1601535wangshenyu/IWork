package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.JobLevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @ResultMap(value = "jobLevelMapper1")
    @Select("SELECT *" +
            " FROM i_tb_joblevel")
    List<JobLevel> iistAllJobLevel();

    @ResultMap(value = "jobLevelMapper1")
    @Insert("INSERT INTO i_tb_joblevel(j_uid, j_name, j_titleLevel, j_enabled)" +
            " VALUE(#{jl.JobLevelUid}, #{jl.name}, #{jl.titleLevel}, #{jl.enabled})")
    int insertJobLevel(@Param(value = "jl") JobLevel jobLevel);

    @Update("<script>\n" +
            "\t UPDATE i_tb_joblevel \n" +
            "     <set>  \n" +
            "        <if test=\"jl.name != null and jl.name != '' \">  \n" +
            "            j_name = #{jl.name},  \n" +
            "        </if>    \n" +
            "        <if test=\"jl.titleLevel != null and jl.titleLevel != '' \">  \n" +
            "            j_titleLevel = #{jl.titleLevel}  \n" +
            "        </if>  \n" +
            "        <if test=\"jl.createDate != null and jl.createDate != '' \">  \n" +
            "            j_createDate = #{jl.createDate}  \n" +
            "        </if>  \n" +
            "        <if test=\"jl.enabled != null \">  \n" +
            "            j_enabled = #{jl.enabled}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE j_uid = #{jl.JobLevelUid}; \n" +
            "     </script>")
    int updateJobLevelByJobLevelId(@Param("jl") JobLevel jobLevel);

    @ResultMap(value = "jobLevelMapper1")
    @Delete("DELETE FROM i_tb_joblevel" +
            " WHERE j_uid = #{uid}")
    int deleteJobLevelByJobLevelUid(@Param(value = "uid") String JobLevelUid);
}
