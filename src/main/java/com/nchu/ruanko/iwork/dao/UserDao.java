package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Results(id="userMapper1",value={
            @Result(property = "userUid", column = "u_uid"),
            @Result(property = "realName", column = "u_real_name"),
            @Result(property = "password", column = "u_password"),
            @Result(property = "nickName", column = "u_nickname"),
            @Result(property = "gender", column = "u_gender"),
            @Result(property = "birthday", column = "u_birthday"),
            @Result(property = "wedLock", column = "u_wedlock"),
            @Result(property = "nation", column = "u_nationId",one = @One(select = "com.nchu.ruanko.iwork.NationDao.getNationByNationUid")),
            @Result(property = "nativePlace", column = "u_nativePlace"),
            @Result(property = "politicsStatus", column = "u_politicId",one = @One(select = "com.nchu.ruanko.iwork.PoliticsStatusDao.getPoliticsStatusByPoliticsStatusUid")),
            @Result(property = "oweDepartment", column = "u_departmentId",one = @One(select = "com.nchu.ruanko.iwork.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "jobLevel", column = "u_joblevelId",one = @One(select = "com.nchu.ruanko.iwork.JobLevelDao.getJobLevelByJobLevelUid")),
            @Result(property = "position", column = "u_posId",one = @One(select = "com.nchu.ruanko.iwork.PositionDao.getPositionByPositionUid")),
            @Result(property = "engageForm", column = "u_engageForm"),
            @Result(property = "specialty", column = "u_specialty"),
            @Result(property = "tiptopDegree", column = "u_tiptopDegree"),
            @Result(property = "school", column = "u_school"),
            @Result(property = "beginDate", column = "u_beginDate"),
            @Result(property = "workId", column = "u_workId"),
            @Result(property = "contractTerm", column = "u_contractTerm"),
            @Result(property = "beginContract", column = "u_beginContract"),
            @Result(property = "endContract", column = "u_endContract"),
            @Result(property = "conversionTime", column = "u_conversionTime"),
            @Result(property = "notWorkDate", column = "u_notWorkDate"),
            @Result(property = "workAge", column = "u_workAge"),
            @Result(property = "phone", column = "u_phone"),
            @Result(property = "mail", column = "u_mail"),
            @Result(property = "idCard", column = "u_idcard"),
            @Result(property = "address", column = "u_address"),
            @Result(property = "employeeState", column = "u_state",one = @One(select = "com.nchu.ruanko.iwork.EmployeeStateDao.getEmployeeStateByEmployeeStateUid")),
            @Result(property = "userFace", column = "u_userface"),
            @Result(property = "remark", column = "u_remark")
    })
    @Select("SELECT *" +
            " FROM gf_tb_user" +
            " WHERE u_workId=#{u_workId} AND u_password=#{password}")
    User getUserByWorkIdAndPassword(@Param(value = "u_workId") String workId, @Param(value = "password") String password);


    @ResultMap(value="userMapper1")
    @Select("SELECT *" +
            " FROM gf_tb_user" +
            " WHERE u_phone=#{u_phone} AND u_password=#{password}")
    User getUserByPhoneAndPassword(@Param(value = "u_phone") String phone, @Param(value = "password") String password);


    @ResultMap(value="userMapper1")
    @Select("SELECT *" +
            " FROM gf_tb_user" +
            " WHERE u_mail=#{u_mail} AND u_password=#{password}")
    User getUserByMailAndPassword(@Param(value = "u_mail") String mail, @Param(value = "password") String password);

}
