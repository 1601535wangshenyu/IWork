package com.nchu.ruanko.iwork.dao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentDao {

    @Results(id = "departmentMapper1", value = {
            @Result(property = "departmentUid", column = "d_id"),
            @Result(property = "name", column = "d_name"),
            @Result(property = "parentDepartment", column = "d_parentId",one = @One(select = "com.nchu.ruanko.iwork.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "path", column = "d_depPath"),
            @Result(property = "enabled", column = "d_enabled"),
            @Result(property = "isParent", column = "d_isParent")
    })
    @Select("SELECT *" +
            " FROM i_tb_department" +
            " WHERE d_id=#{uid}")
    DepartmentDao getDepartmentByDepartmentUid(@Param(value = "uid") String departmentUid);

}
