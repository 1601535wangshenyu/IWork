package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.EmployeeState;
import org.apache.ibatis.annotations.*;

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

}
