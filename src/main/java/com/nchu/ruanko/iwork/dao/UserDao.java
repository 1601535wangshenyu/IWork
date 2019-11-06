package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
            @Result(property = "nation", column = "u_nationId",one = @One(select = "com.nchu.ruanko.iwork.dao.NationDao.getNationByNationUid")),
            @Result(property = "nativePlace", column = "u_nativePlace"),
            @Result(property = "politicsStatus", column = "u_politicId",one = @One(select = "com.nchu.ruanko.iwork.dao.PoliticsStatusDao.getPoliticsStatusByPoliticsStatusUid")),
            @Result(property = "oweDepartment", column = "u_departmentId",one = @One(select = "com.nchu.ruanko.iwork.dao.DepartmentDao.getDepartmentByDepartmentUid")),
            @Result(property = "jobLevel", column = "u_joblevelId",one = @One(select = "com.nchu.ruanko.iwork.dao.JobLevelDao.getJobLevelByJobLevelUid")),
            @Result(property = "position", column = "u_posId",one = @One(select = "com.nchu.ruanko.iwork.dao.PositionDao.getPositionByPositionUid")),
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
            @Result(property = "employeeState", column = "u_state",one = @One(select = "com.nchu.ruanko.iwork.dao.EmployeeStateDao.getEmployeeStateByEmployeeStateUid")),
            @Result(property = "userFace", column = "u_userface"),
            @Result(property = "remark", column = "u_remark")
    })
    @Select("SELECT *" +
            " FROM i_tb_user" +
            " WHERE u_workId=#{u_workId} AND u_password=#{password}")
    User getUserByWorkIdAndPassword(@Param(value = "u_workId") String workId, @Param(value = "password") String password);

    @ResultMap(value="userMapper1")
    @Select("SELECT *" +
            " FROM i_tb_user" +
            " WHERE u_phone=#{u_phone} AND u_password=#{password}")
    User getUserByPhoneAndPassword(@Param(value = "u_phone") String phone, @Param(value = "password") String password);

    @ResultMap(value="userMapper1")
    @Select("SELECT *" +
            " FROM i_tb_user" +
            " WHERE u_mail=#{u_mail} AND u_password=#{password}")
    User getUserByMailAndPassword(@Param(value = "u_mail") String mail, @Param(value = "password") String password);

    @ResultMap(value = "userMapper1")
    @Select("SELECT *" +
            "FROM i_tb_user")
    List<User> listAllUsers();

    @ResultMap(value = "userMapper1")
    @Select("SELECT *" +
            " FROM i_tb_user" +
            " WHERE u_uid = #{u_uid}")
    User getUserByUserId(@Param(value = "u_uid") String userUid);

    @ResultMap(value = "userMapper1")
    @Insert("INSERT INTO i_tb_user(u_uid, u_real_name, u_nickname, u_password, u_gender, u_birthday, u_wedlock, u_nationId, u_nativePlace, u_politicId, u_departmentId, u_joblevelId, u_posId, u_engageForm, u_specialty, u_tiptopDegree, u_school, u_beginDate, u_workId, u_contractTerm, u_beginContract, u_endContract, u_conversionTime, u_notWorkDate, u_workAge, u_phone, u_mail, u_idcard, u_address, u_state, u_userface, u_remark)" +
            " VALUE(#{er.userUid}, #{er.realName}, #{er.password}, #{er.nickName}, #{er.gender}, #{er.birthday}, #{er.wedLock}, #{er.nation.nationUid}, #{er.nativePlace}, #{er.politicsStatus.politicsStatusUId}, #{er.oweDepartment.departmentUid}, #{er.jobLevel.JobLevelUid}, #{er.position.positionUid}, #{er.engageForm}, #{er.specialty}, #{er.tiptopDegree}, #{er.school}, #{er.beginDate}, #{er.workId}, #{er.contractTerm}, #{er.beginContract}, #{er.endContract}, #{er.conversionTime}, #{er.notWorkDate}, #{er.workAge}, #{er.phone}, #{er.mail}, #{er.idCard}, #{er.address}, #{er.employeeState.employeeStateId}, #{er.userFace}, #{er.remark})")
    int insertUser(@Param("er") User user);


    @Update("<script>\n" +
            "\t UPDATE i_tb_user \n" +
            "     <set>  \n" +
            "        <if test=\"uer.realName != null and uer.realName != '' \">  \n" +
            "            u_real_name = #{uer.realName},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nickName != null and uer.nickName != '' \">  \n" +
            "            u_nickname = #{uer.nickName},  \n" +
            "        </if>    \n" +
            "        <if test=\"uer.password != null and uer.password != '' \">  \n" +
            "            u_password = #{uer.password},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.gender != null and uer.gender != '' \">  \n" +
            "            u_gender = #{uer.gender},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.birthday != null and uer.birthday != '' \">  \n" +
            "            u_birthday = #{uer.birthday},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.wedLock != null and uer.wedLock != '' \">  \n" +
            "            u_wedlock = #{uer.wedLock},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nation != null \">  \n" +
            "            u_nationId = #{uer.nation.nationUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nativePlace != null and uer.nativePlace != '' \">  \n" +
            "            u_nativePlace = #{uer.nativePlace},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.politicsStatus != null \">  \n" +
            "            u_politicId = #{uer.politicsStatus.politicsStatusUId},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.oweDepartment != null \">  \n" +
            "            u_departmentId = #{uer.oweDepartment.departmentUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.jobLevel != null \">  \n" +
            "            u_joblevelId = #{uer.jobLevel.JobLevelUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.position != null \">  \n" +
            "            u_posId = #{uer.position.positionUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.engageForm != null and uer.engageForm != '' \">  \n" +
            "            u_engageForm = #{uer.engageForm},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.specialty != null and uer.specialty != '' \">  \n" +
            "            u_specialty = #{uer.specialty},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.tiptopDegree != null and uer.tiptopDegree != '' \">  \n" +
            "            u_tiptopDegree = #{uer.tiptopDegree},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.school != null and uer.school != '' \">  \n" +
            "            u_school = #{uer.school},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.beginDate != null and uer.beginDate != '' \">  \n" +
            "            u_beginDate = #{uer.beginDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.workId != null and uer.workId != '' \">  \n" +
            "            u_workId = #{uer.workId},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.contractTerm != null \">  \n" +
            "            u_contractTerm = #{uer.contractTerm},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.beginContract != null and uer.beginContract != '' \">  \n" +
            "            u_beginContract = #{uer.beginContract},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.endContract != null and uer.endContract != '' \">  \n" +
            "            u_endContract = #{uer.endContract},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.conversionTime != null and uer.conversionTime != '' \">  \n" +
            "            u_conversionTime = #{uer.conversionTime},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.notWorkDate != null and uer.notWorkDate != '' \">  \n" +
            "            u_notWorkDate = #{uer.notWorkDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.workAge != null \">  \n" +
            "            u_workAge = #{uer.workAge},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.phone != null and uer.phone != '' \">  \n" +
            "            u_phone = #{uer.phone},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.mail != null and uer.mail != '' \">  \n" +
            "            u_mail = #{uer.mail},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.idCard != null and uer.idCard != '' \">  \n" +
            "            u_idcard = #{uer.idCard},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.address != null and uer.address != '' \">  \n" +
            "            u_address = #{uer.address},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.employeeState != null \">  \n" +
            "            u_state = #{uer.employeeState},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.userFace != null and uer.userFace != '' \">  \n" +
            "            u_userface = #{uer.userFace},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.remark != null and uer.remark != '' \">  \n" +
            "            u_remark = #{uer.remark}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE u_uid = #{uer.userUid}; \n" +
            "     </script>")
    int updateUserByUserId(@Param("uer") User user);

    @Update("<script>\n" +
            "\t UPDATE i_tb_user \n" +
            "     <set>  \n" +
            "        <if test=\"uer.realName != null and uer.realName != '' \">  \n" +
            "            u_real_name = #{uer.realName},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nickName != null and uer.nickName != '' \">  \n" +
            "            u_nickname = #{uer.nickName},  \n" +
            "        </if>    \n" +
            "        <if test=\"uer.password != null and uer.password != '' \">  \n" +
            "            u_password = #{uer.password},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.gender != null and uer.gender != '' \">  \n" +
            "            u_gender = #{uer.gender},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.birthday != null and uer.birthday != '' \">  \n" +
            "            u_birthday = #{uer.birthday},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.wedLock != null and uer.wedLock != '' \">  \n" +
            "            u_wedlock = #{uer.wedLock},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nation != null \">  \n" +
            "            u_nationId = #{uer.nation.nationUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.nativePlace != null and uer.nativePlace != '' \">  \n" +
            "            u_nativePlace = #{uer.nativePlace},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.politicsStatus != null \">  \n" +
            "            u_politicId = #{uer.politicsStatus.politicsStatusUId},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.oweDepartment != null \">  \n" +
            "            u_departmentId = #{uer.oweDepartment.departmentUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.jobLevel != null \">  \n" +
            "            u_joblevelId = #{uer.jobLevel.JobLevelUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.position != null \">  \n" +
            "            u_posId = #{uer.position.positionUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.engageForm != null and uer.engageForm != '' \">  \n" +
            "            u_engageForm = #{uer.engageForm},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.specialty != null and uer.specialty != '' \">  \n" +
            "            u_specialty = #{uer.specialty},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.tiptopDegree != null and uer.tiptopDegree != '' \">  \n" +
            "            u_tiptopDegree = #{uer.tiptopDegree},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.school != null and uer.school != '' \">  \n" +
            "            u_school = #{uer.school},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.beginDate != null and uer.beginDate != '' \">  \n" +
            "            u_beginDate = #{uer.beginDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.workId != null and uer.workId != '' \">  \n" +
            "            u_workId = #{uer.workId},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.contractTerm != null \">  \n" +
            "            u_contractTerm = #{uer.contractTerm},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.beginContract != null and uer.beginContract != '' \">  \n" +
            "            u_beginContract = #{uer.beginContract},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.endContract != null and uer.endContract != '' \">  \n" +
            "            u_endContract = #{uer.endContract},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.conversionTime != null and uer.conversionTime != '' \">  \n" +
            "            u_conversionTime = #{uer.conversionTime},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.notWorkDate != null and uer.notWorkDate != '' \">  \n" +
            "            u_notWorkDate = #{uer.notWorkDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.workAge != null \">  \n" +
            "            u_workAge = #{uer.workAge},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.phone != null and uer.phone != '' \">  \n" +
            "            u_phone = #{uer.phone},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.mail != null and uer.mail != '' \">  \n" +
            "            u_mail = #{uer.mail},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.idCard != null and uer.idCard != '' \">  \n" +
            "            u_idcard = #{uer.idCard},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.address != null and uer.address != '' \">  \n" +
            "            u_address = #{uer.address},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.employeeState != null \">  \n" +
            "            u_state = #{uer.employeeState},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.userFace != null and uer.userFace != '' \">  \n" +
            "            u_userface = #{uer.userFace},  \n" +
            "        </if>  \n" +
            "        <if test=\"uer.remark != null and uer.remark != '' \">  \n" +
            "            u_remark = #{uer.remark}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE u_workId = #{uer.workId}; \n" +
            "     </script>")
    int updateUserByWorkId(@Param("uer") User user);

    @ResultMap(value = "userMapper1")
    @Delete("DELETE FROM i_tb_user" +
            " WHERE u_uid = #{uid}")
    int deleteUserByUserId(@Param("uid") String userUid);

    @Select("SELECT COUNT(*)" +
            " FROM i_tb_user" +
            " WHERE u_mail=#{mail}")
    int countUserByMail(@Param("mail")String mail);

    @Select("SELECT COUNT(*)" +
            " FROM i_tb_user" +
            " WHERE u_phone=#{phone}")
    int countUserByPhone(@Param("phone") String phone);
}
