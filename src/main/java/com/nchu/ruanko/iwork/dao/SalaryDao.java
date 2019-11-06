package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalaryDao {
    @Results(id = "salaryMapper1", value = {
            @Result(property = "salaryUid", column = "s_uid"),
            @Result(property = "basicSalary", column = "basicSalary"),
            @Result(property = "bonus", column = "bonus"),
            @Result(property = "lunchSalary", column = "lunchSalary"),
            @Result(property = "trafficSalary", column = "trafficSalary"),
            @Result(property = "allSalary", column = "allSalary"),
            @Result(property = "pensionBase", column = "pensionBase"),
            @Result(property = "pensionPer", column = "pensionPer"),
            @Result(property = "createDate", column = "createDate"),
            @Result(property = "medicalBase", column = "medicalBase"),
            @Result(property = "medialPer", column = "medialPer"),
            @Result(property = "accumulationFundBase", column = "accumulationFundBase"),
            @Result(property = "accumulationFundPer", column = "accumulationFundPer"),
            @Result(property = "name", column = "name")
    })
    @Select("SELECT *" +
            " FROM i_tb_salary" +
            " WHERE s_uid = #{uid}")
    Salary getSalaryBySalaryId(@Param(value = "uid") String salaryUid);

    @ResultMap(value = "salaryMapper1")
    @Select("SELECT *" +
            " FROM i_tb_salary")
    List<Salary> listAllSalary();

    @ResultMap(value = "salaryMapper1")
    @Insert("INSERT INTO i_tb_salary(s_uid, basicSalary, bonus, lunchSalary, trafficSalary, allSalary, pensionBase, pensionPer, medicalBase, medialPer, accumulationFundBase, accumulationFundPer, name)" +
            " VALUE(#{sal.salaryUid}, #{sal.basicSalary}, #{sal.bonus}, #{sal.lunchSalary}, #{sal.trafficSalary}, #{sal.allSalary}, #{sal.pensionBase}, #{sal.pensionPer}, #{sal.medicalBase}, #{sal.medialPer}, #{sal.accumulationFundBase}, #{sal.accumulationFundPer}, #{sal.name})")
    int insertSalary(@Param("sal") Salary salary);

    @ResultMap(value = "salaryMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_salary \n" +
            "     <set>  \n" +
            "        <if test=\"usal.basicSalary != null \">  \n" +
            "            basicSalary = #{usal.basicSalary},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.bonus != null \">  \n" +
            "            bonus = #{usal.bonus},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.lunchSalary != null \">  \n" +
            "            lunchSalary = #{usal.lunchSalary},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.trafficSalary != null \">  \n" +
            "            trafficSalary = #{usal.trafficSalary},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.allSalary != null \">  \n" +
            "            allSalary = #{usal.allSalary},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.pensionBase != null \">  \n" +
            "            pensionBase = #{usal.pensionBase},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.pensionPer != null \">  \n" +
            "            pensionPer = #{usal.pensionPer},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.medicalBase != null \">  \n" +
            "            medicalBase = #{usal.medicalBase},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.medialPer != null \">  \n" +
            "            medialPer = #{usal.medialPer},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.accumulationFundBase != null \">  \n" +
            "            accumulationFundBase = #{usal.accumulationFundBase},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.accumulationFundPer != null \">  \n" +
            "            accumulationFundPer = #{usal.accumulationFundPer},  \n" +
            "        </if>  \n" +
            "        <if test=\"usal.name != null and usal.name != '' \">  \n" +
            "            name = #{usal.name},  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE s_uid = #{usal.salaryUid}; \n" +
            "     </script>")
    int updateSalaryBySalaryId(@Param("usal") Salary salary);

    @ResultMap(value = "salaryMapper1")
    @Delete("DELETE FROM i_tb_salary" +
            " WHERE s_uid = #{uid}")
    int deleteSalaryBySalaryId(@Param(value = "uid") String salaryUid);
}
