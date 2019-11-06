package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Empsalary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpsalaryDao {

    @Results(id = "empsalaryMapper1", value = {
            @Result(property = "empsalaryUid", column = "es_uid"),
            @Result(property = "user", column = "es_eid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "salary", column = "es_sid",one = @One(select = "com.nchu.ruanko.iwork.dao.SalaryDao.getSalaryBySalaryId"))
    })
    @Select("SELECT *" +
            " FROM i_tb_empsalary" +
            " WHERE es_uid=#{uid}")
    Empsalary getEmpsalaryDaoByEmpsalaryDaoId(@Param(value = "uid") String empsalaryUid);

    @ResultMap(value = "empsalaryMapper1")
    @Select("SELECT *" +
            " FROM i_tb_empsalary")
    List<Empsalary> listAllEmpsalary();

    @ResultMap(value = "empsalaryMapper1")
    @Insert("INSERT INTO i_tb_empsalary(es_uid, es_eid, es_sid)" +
            " VALUE(#{emp.empsalaryUid}, #{emp.user.userUid}, #{emp.salary.salaryUid})")
    int insertEmpsalary(@Param("emp") Empsalary empsalary);

    @ResultMap(value = "empsalaryMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_empsalary \n" +
            "     <set>  \n" +
            "        <if test=\"uemp.user != null \">  \n" +
            "            es_eid = #{uemp.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.salary != null \">  \n" +
            "            es_sid = #{uemp.salary.salaryUid},  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE es_uid = #{uemp.empsalaryUid}; \n" +
            "     </script>")
    int updateEmpsalaryDaoByEmpsalaryDaoId(@Param("uemp") Empsalary empsalary);

    @ResultMap(value = "empsalaryMapper1")
    @Delete("DELETE FROM i_tb_empsalary" +
            " WHERE es_uid = #{uid}")
    int deleteEmpsalaryDaoByEmpsalaryDaoId(@Param("uid") String empsalaryUid);
}

/*private String empsalaryUid;
    private User user;
    private Salary salary;*/
