package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Leave;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeaveDao {

    @Results(id = "leaveMapper1", value = {
            @Result(property = "leaveId", column = "l_leaveId"),
            @Result(property = "applyPerson", column = "l_applyPerson", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "applyDate", column = "l_applyDate"),
            @Result(property = "applyReason", column = "l_applyReason"),
            @Result(property = "leavetype", column = "l_leaveTypeId", one = @One(select = "com.nchu.ruanko.iwork.dao.LeavetypeDao.getLeavetypeByLeavetypeId")),
            @Result(property = "startTime", column = "l_startTime"),
            @Result(property = "endTime", column = "l_endTime"),
            @Result(property = "leaveTime", column = "l_leaveTime"),
            @Result(property = "approveDate", column = "l_approveDate"),
            @Result(property = "approver", column = "l_approver", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "approveResult", column = "l_approveResult"),
            @Result(property = "state", column = "l_state")
    })
    @Select("SELECT *" +
            " FROM i_tb_leave" +
            " WHERE l_leaveId = #{uid}")
    Leave getLeaveByLeaveId(@Param(value = "uid") String leaveId);

    @ResultMap(value = "leaveMapper1")
    @Select("SELECT *" +
            " FROM i_tb_leave")
    List<Leave> listAllLeave();

    @ResultMap(value = "leaveMapper1")
    @Insert("INSERT INTO i_tb_leave(l_leaveId, l_applyPerson, l_applyDate, l_applyReason, l_leaveTypeId, l_startTime, l_endTime, l_leaveTime, l_approveDate, l_approver, l_approveResult, l_state)" +
            " VALUE(#{lev.leaveId}, #{lev.applyPerson.userUid}, #{lev.applyDate}, #{lev.applyReason}, #{lev.leavetype.leavetypeId}, #{lev.startTime}, #{lev.endTime}, #{lev.leaveTime}, #{lev.approveDate}, #{lev.approver.userUid}, #{lev.approveResult}, #{lev.state})")
    int insertLeave(@Param("lev") Leave leave);

    @ResultMap(value = "leaveMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_leave \n" +
            "     <set>  \n" +
            "        <if test=\"ulev.applyPerson != null \">  \n" +
            "            l_applyPerson = #{ulev.applyPerson.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.applyDate != null and ulev.applyDate != '' \">  \n" +
            "            l_applyDate = #{ulev.applyDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.applyReason != null and ulev.applyReason != '' \">  \n" +
            "            l_applyReason = #{ulev.applyReason},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.leavetype != null \">  \n" +
            "            l_leaveTypeId = #{ulev.leavetype.leavetypeId},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.startTime != null and ulev.startTime != '' \">  \n" +
            "            l_startTime = #{ulev.startTime},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.endTime != null and ulev.endTime != '' \">  \n" +
            "            l_endTime = #{ulev.endTime},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.leaveTime != null and ulev.leaveTime != '' \">  \n" +
            "            l_leaveTime = #{ulev.leaveTime},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.approveDate != null and ulev.approveDate != '' \">  \n" +
            "            l_approveDate = #{ulev.approveDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.approver != null \">  \n" +
            "            l_approver = #{ulev.approver.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.approveResult != null and ulev.approveResult != '' \">  \n" +
            "            l_approveResult = #{ulev.approveResult},  \n" +
            "        </if>  \n" +
            "        <if test=\"ulev.state != null \">  \n" +
            "            l_state = #{ulev.state}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE l_leaveId = #{ulev.leaveId}; \n" +
            "     </script>")
    int updateLeaveByLeaveId(@Param("ulev") Leave leave);

    @ResultMap(value = "leaveMapper1")
    @Delete("DELETE FROM i_tb_leave" +
            " WHERE l_leaveId = #{uid}")
    int deleteLeaveByLeaveId(@Param("uid") String leaveId);
}
/*private String leaveId;
private User applyPerson;
private Date applyDate;
private String applyReason;
private Leavetype leavetype;
private Date startTime;
private Date endTime;
private String leaveTime;
private Date approveDate;
private User approver;
private String approveResult;
private int state;*/
