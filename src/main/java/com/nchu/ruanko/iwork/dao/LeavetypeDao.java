package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Leavetype;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeavetypeDao {
    @Results(id = "leavetypeMapper1", value = {
            @Result(property = "leavetypeId", column = "lt_leaveTypeId"),
            @Result(property = "leaveType", column = "lt_leaveType")
    })
    @Select("SELECT *" +
            " FROM i_tb_leavetype"  +
            " WHERE lt_leaveTypeId = #{uid}")
    Leavetype getLeavetypeByLeavetypeId(@Param(value = "uid") int leavetypeId);

    @ResultMap(value = "leavetypeMapper1")
    @Select("SELECT *" +
            " FROM i_tb_leavetype")
    List<Leavetype> listAllLeavetype();

    @ResultMap(value = "leavetypeMapper1")
    @Insert("INSERT INTO i_tb_leavetype(lt_leaveTypeId, lt_leaveType)" +
            " VALUE(#{lt.leavetypeId}, #{lt.leaveType})")
    int insertLeavetype(@Param("lt") Leavetype leavetype);

    @ResultMap(value = "leavetypeMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_leavetype \n" +
            "     <set>  \n" +
            "        <if test=\"ult.leaveType != null and ult.leaveType != '' \">  \n" +
            "            lt_leaveType = #{ult.leaveType},  \n" +
            "        </if>    \n" +
            "     </set>  \n" +
            "\t\tWHERE lt_leaveTypeId = #{ult.leavetypeId}; \n" +
            "     </script>")
    int updateLeavetypeByLeavetypeId(@Param("ult") Leavetype leavetype);

    @ResultMap(value = "leavetypeMapper1")
    @Delete("DELETE FROM i_tb_leavetype" +
            " WHERE lt_leaveTypeId = #{uid}")
    int deleteLeavetypeByLeavetypeId(@Param("uid") int leavetypeId);

}
/*private int leavetypeId;
    private String leaveType;*/
