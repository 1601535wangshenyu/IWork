package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.EmployeeState;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeStateDao {

    @Results(id = "employeeStateMapper1", value = {
            @Result(property = "employeeStateId", column = "es_employeeStateId"),
            @Result(property = "employeeState", column = "es_employeeState"),
            @Result(property = "remark", column = "es_remark")
    })
    @Select("SELECT *" +
            " FROM i_tb_employee_state" +
            " WHERE es_employeeStateId=#{uid}")
    EmployeeState getEmployeeStateByEmployeeStateUid(@Param(value = "uid") String employeeStateUid);

    @ResultMap(value = "employeeStateMapper1")
    @Select("SELECT *" +
            " FROM i_tb_employee_state")
    List<EmployeeState> listALLEmployeeState();

    @ResultMap(value = "employeeStateMapper1")
    @Insert("INSERT INTO i_tb_employee_state(es_employeeStateId, es_employeeState, es_remark)" +
            " VALUE(#{es.employeeStateId}, #{es.employeeState}, #{es.remark})")
    int insertEmployeeState(@Param(value = "es") EmployeeState employeeState);

    @Update("<script>\n" +
            "\t UPDATE i_tb_employee_state  \n" +
            "     <set>  \n" +
            "        <if test=\"ems.employeeState != null and ems.employeeState != '' \">  \n" +
            "            es_employeeState = #{ems.employeeState},  \n" +
            "        </if>  \n" +
            "        <if test=\"ems.remark != null and ems.remark != '' \">  \n" +
            "            es_remark = #{ems.remark},  \n" +
            "        </if>    \n" +
            "     </set>  \n" +
            "\t\tWHERE es_employeeStateId = #{ems.employeeStateId}; \n" +
            "     </script>")
    int updateEmployeeStateByEmployeeStateId(@Param("ems") EmployeeState employeeState);

    @ResultMap(value = "employeeStateMapper1")
    @Delete("DELETE FROM i_tb_employee_state" +
            " WHERE es_employeeStateId = #{uid}")
    int deleteEmployeeStateByEmployeeStateId(@Param(value = "uid") Integer employeeStateUid);
}
