package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Appraise;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppraiseDao {

    @Results(id = "appraiseMapper1", value = {
            @Result(property = "appraiseUid", column = "a_uid"),
            @Result(property = "user", column = "a_eid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "appDate", column = "a_appDate"),
            @Result(property = "appResult", column = "a_appResult"),
            @Result(property = "appContent", column = "a_appContent"),
            @Result(property = "remark", column = "a_remark")
    })
    @Select("SELECT *" +
            " FROM i_tb_appraise" +
            " WHERE a_uid=#{uid}")
    Appraise getAppraiseByAppraiseId(@Param(value = "uid") String appraiseUid);

    @ResultMap(value = "appraiseMapper1")
    @Select("SELECT *" +
            " FROM i_tb_appraise")
    List<Appraise> listAllAppraise();

    @ResultMap(value = "appraiseMapper1")
    @Insert("INSERT INTO i_tb_appraise(a_uid, a_eid, a_appDate, a_appResult, a_appContent, a_remark)" +
            " VALUE(#{app.appraiseUid}, #{app.user.userUid}, #{app.appDate}, #{app.appResult}, #{app.appContent}, #{app.remark})")
    int insertAppraise(@Param("app") Appraise appraise);

    @ResultMap(value = "appraiseMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_appraise \n" +
            "     <set>  \n" +
            "        <if test=\"uapp.user != null \">  \n" +
            "            a_eid = #{uapp.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uapp.appDate != null and uapp.appDate != '' \">  \n" +
            "            a_appDate = #{uapp.appDate},  \n" +
            "        </if>    \n" +
            "        <if test=\"uapp.appResult != null and uapp.appResult != '' \">  \n" +
            "            a_appResult = #{uapp.appResult}  \n" +
            "        </if>  \n" +
            "        <if test=\"uapp.appContent != null and uapp.appContent != '' \">  \n" +
            "            a_appContent = #{uapp.appContent}  \n" +
            "        </if>  \n" +
            "        <if test=\"uapp.remark != null and uapp.remark != '' \">  \n" +
            "            a_remark = #{uapp.remark}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE a_uid = #{uapp.appraiseUid}; \n" +
            "     </script>")
    int updateAppraiseByAppraiseId(@Param("uapp") Appraise appraise);

    @ResultMap(value = "appraiseMapper1")
    @Delete("DELETE FROM i_tb_appraise" +
            " WHERE a_uid=#{uid}")
    int deleteAppraiseByAppraiseId(@Param("uid") String appraiseUid);
}

/*private String appraiseUid;
    private User user;
    private Date appDate;
    private String appResult;
    private String appContent;
    private String remark;*/
