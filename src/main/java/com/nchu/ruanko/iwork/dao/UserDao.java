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
            @Result(property = "nation", column = "u_nationId"),
            @Result(property = "nativePlace", column = "u_nativePlace"),
            @Result(property = "politicsStatus", column = "u_politicId"),
            @Result(property = "oweDepartment", column = "u_departmentId"),
            @Result(property = "jobLevel", column = "u_joblevelId"),
            @Result(property = "position", column = "u_posId"),
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
            @Result(property = "employeeState", column = "u_state"),
            @Result(property = "userFace", column = "u_userface"),
            @Result(property = "remark", column = "u_remark")
    })
    @Select("SELECT *" +
            " FROM gf_tb_user" +
            " WHERE u_workId=#{u_workId} AND u_password=#{password}")
    User getUserByUsernameAndPassword(@Param(value = "u_workId") String workId, @Param(value = "password") String password);


}
