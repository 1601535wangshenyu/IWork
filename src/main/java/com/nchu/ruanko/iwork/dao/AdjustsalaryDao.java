package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Adjustsalary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdjustsalaryDao {
    @Results(id = "adjustsalaryMapper1", value = {
            @Result(property = "adjustsalaryUid", column = "as_uid"),
            @Result(property = "user", column = "as_eid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "asDate", column = "as_asDate"),
            @Result(property = "beforeSalary", column = "as_beforeSalary", one = @One(select = "com.nchu.ruanko.iwork.dao.SalaryDao.getSalaryBySalaryId")),
            @Result(property = "afterSalary", column = "as_afterSalary", one = @One(select = "com.nchu.ruanko.iwork.dao.SalaryDao.getSalaryBySalaryId")),
            @Result(property = "reason", column = "as_reason"),
            @Result(property = "remark", column = "as_remark")
    })
    @Select("SELECT *" +
            " FROM i_tb_adjustsalary" +
            " WHERE as_uid = #{ad}")
    Adjustsalary getAdjustsalaryByAdjustsalaryId(@Param(value = "ad") String adjustsalaryUid);

    @ResultMap(value = "adjustsalaryMapper1")
    @Select("SELECT *" +
            " FROM i_tb_adjustsalary")
    List<Adjustsalary> listAllAdjustsalary();

    @ResultMap(value = "adjustsalaryMapper1")
    @Insert("INSERT INTO i_tb_adjustsalary(as_uid, as_eid, as_asDate, as_beforeSalary, as_afterSalary, as_reason, as_remark)" +
            " VALUE(#{ads.adjustsalaryUid}, #{ads.user.userUid}, #{ads.asDate}, #{ads.beforeSalary.salaryUid}, #{ads.afterSalary.salaryUid}, #{ads.reason}, #{ads.remark})")
    int insertAdjustsalary(@Param("ads") Adjustsalary adjustsalary);

    @ResultMap(value = "adjustsalaryMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_adjustsalary \n" +
            "     <set>  \n" +
            "        <if test=\"uads.user != null and uads.user != '' \">  \n" +
            "            as_eid = #{uads.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uads.asDate != null and uads.asDate != '' \">  \n" +
            "            as_asDate = #{uads.asDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uads.beforeSalary != null and uads.beforeSalary != '' \">  \n" +
            "            as_beforeSalary = #{uads.beforeSalary.salaryUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uads.afterSalary != null and uads.afterSalary != '' \">  \n" +
            "            as_afterSalary = #{uads.afterSalary.salaryUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uads.reason != null and uads.reason != '' \">  \n" +
            "            as_reason = #{uads.reason},  \n" +
            "        </if>  \n" +
            "        <if test=\"uads.remark != null and uads.remark != '' \">  \n" +
            "            as_remark = #{uads.remark},  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE as_uid = #{uads.adjustsalaryUid}; \n" +
            "     </script>")
    int updateAdjustsalaryByAdjustsalaryId(@Param("uads") Adjustsalary adjustsalary);

    @Delete("DELETE FROM i_tb_adjustsalary" +
            " WHERE as_uid = #{uid}")
    int deleteAdjustsalaryByAdjustsalaryId(@Param("uid") String adjustsalaryUid);
}
    /*private String adjustsalaryUid;
    private User user;
    private Date asDate;
    private Salary beforeSalary;
    private Salary afterSalary;
    private String reason;
    private String remark;*/