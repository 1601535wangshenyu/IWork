package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Employeeremove;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeremoveDao {

    @Results(id = "employeeremoveMapper1", value = {
            @Result(property = "employeeremoveUid", column = "er_uid"),
            @Result(property = "user", column = "er_eid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "afterDep", column = "er_afterDepId", one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "afterJob", column = "er_afterJobId", one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "beforeDep", column = "er_beforeDepId", one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "beforeJob", column = "er_beforeJopId", one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "removeDate", column = "er_removeDate"),
            @Result(property = "reason", column = "er_reason"),
            @Result(property = "remark", column = "er_remark")
    })
    @Select("SELECT *" +
            " FROM i_tb_employeeremove" +
            " WHERE er_uid = #{eid}")
    Employeeremove getEmployeeremoveByEmployeeremoveid(@Param(value = "eid") String employeeremoveUid);

    @ResultMap(value = "employeeremoveMapper1")
    @Select("SELECT *" +
            " FROM i_tb_employeeremove")
    List<Employeeremove> listAllEmployeeremove();

    @ResultMap(value = "employeeremoveMapper1")
    @Insert("INSERT INTO i_tb_employeeremove(er_uid, er_eid, er_afterDepId, er_afterJobId, er_beforeDepId, er_beforeJopId, er_removeDate, er_reason, er_remark)" +
            " VALUE(#{emp.employeeremoveUid}, #{emp.user.userUid}, #{emp.afterDep.departmentUid}, #{emp.afterJob.departmentUid}, #{emp.beforeDep.departmentUid}, #{emp.beforeJob.departmentUid}, #{emp.removeDate}, #{emp.reason}, #{emp.remark})")
    int insertEmployeeremove(@Param("emp") Employeeremove employeeremove);

    @ResultMap(value = "employeeremoveMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_employeeremove \n" +
            "     <set>  \n" +
            "        <if test=\"uemp.user != null and uemp.user != '' \">  \n" +
            "            er_eid = #{uemp.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.afterDep != null \">  \n" +
            "            er_afterDepId = #{uemp.afterDep.departmentUid},  \n" +
            "        </if>    \n" +
            "        <if test=\"uemp.afterJob != null \">  \n" +
            "            er_afterJobId = #{uemp.afterJob.departmentUid}  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.beforeDep != null \">  \n" +
            "            er_beforeDepId = #{uemp.beforeDep.departmentUid}  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.beforeJob != null \">  \n" +
            "            er_beforeJopId = #{uemp.beforeJob.departmentUid}  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.removeDate != null and uemp.removeDate != '' \">  \n" +
            "            er_removeDate = #{uemp.removeDate}  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.reason != null and uemp.reason != '' \">  \n" +
            "            er_reason = #{uemp.reason}  \n" +
            "        </if>  \n" +
            "        <if test=\"uemp.remark != null and uemp.remark != '' \">  \n" +
            "            er_remark = #{uemp.remark}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE er_uid = #{uemp.employeeremoveUid}; \n" +
            "     </script>")
    int updateEmployeeremoveByEmployeeremoveid(@Param("uemp") Employeeremove employeeremove);

    @ResultMap(value = "employeeremoveMapper1")
    @Delete("DELETE FROM i_tb_employeeremove" +
            " WHERE er_uid = #{uid}")
    int deleteEmployeeremoveByEmployeeremoveid(@Param("uid") String employeeremoveUid);
}
