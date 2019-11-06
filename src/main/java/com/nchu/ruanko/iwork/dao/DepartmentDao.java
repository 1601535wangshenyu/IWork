package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentDao {

    @Results(id = "departmentMapper1", value = {
            @Result(property = "departmentUid", column = "d_id"),
            @Result(property = "name", column = "d_name"),
            @Result(property = "parentDepartment", column = "d_parentId", one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "path", column = "d_depPath"),
            @Result(property = "enabled", column = "d_enabled"),
            @Result(property = "isParent", column = "d_isParent")
    })
    @Select("SELECT *" +
            " FROM i_tb_department" +
            " WHERE d_id = #{uid}")
    Department getDepartmentByDepartmentUid(@Param(value = "uid") String departmentUid);

    @ResultMap(value = "departmentMapper1")
    @Select("SELECT *" +
            " FROM i_tb_department")
    List<Department> listAllDepartment();

    @ResultMap(value = "departmentMapper1")
    @Insert("INSERT INTO i_tb_department(d_id, d_name, d_parentId, d_depPath, d_enabled, d_isParent)" +
            " VALUE(#{dp.departmentUid}, #{dp.name}, #{dp.parentDepartment.departmentUid}, #{dp.path}, #{dp.enabled}, #{dp.isParent})")
    int insertDepartment(@Param(value = "dp") Department department);

    @ResultMap(value = "departmentMapper1")
    @Delete("DELETE FROM i_tb_department" +
            " WHERE d_id = #{uid}")
    int deleteDepartmentByDepartmentId(@Param(value = "uid") Integer departmentUid);

    @Update("<script>\n" +
            "\t UPDATE i_tb_department \n" +
            "     <set>  \n" +
            "        <if test=\"depart.name != null and depart.name != '' \">  \n" +
            "            d_name = #{depart.name},  \n" +
            "        </if>  \n" +
            "        <if test=\"depart.parentDepartment != null \">  \n" +
            "            d_parentId = #{depart.parentDepartment.departmentUid},  \n" +
            "        </if>    \n" +
            "        <if test=\"depart.path != null and depart.path != '' \">  \n" +
            "            d_depPath = #{depart.path},  \n" +
            "        </if>  \n" +
            "        <if test=\"depart.enabled != null \">  \n" +
            "            d_enabled = #{depart.enabled},  \n" +
            "        </if>  \n" +
            "        <if test=\"depart.isParent != null \">  \n" +
            "            d_isParent = #{depart.isParent}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE d_id = #{depart.departmentUid}; \n" +
            "     </script>")
    int updateDepartmentByDepartmentId(@Param("depart")Department department);
}
