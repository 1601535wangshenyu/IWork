package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Position;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionDao {
    @Results(id = "positionMapper1", value = {
            @Result(property = "positionUid", column = "p_uid"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "createDate", column = "p_createDate"),
            @Result(property = "enabled", column = "p_enabled")
    })
    @Select("SELECT *" +
            " FROM i_tb_position" +
            " WHERE p_uid=#{uid}")
    Position getPositionByPositionUid(@Param(value = "uid") String positionUid);

    @ResultMap(value = "positionMapper1")
    @Select("SELECT *" +
            " FROM i_tb_position")
    List<Position> listAllPosition();

    @ResultMap(value = "positionMapper1")
    @Insert("INSERT INTO i_tb_position(p_uid, p_name, p_enabled)" +
            " VALUE(#{pt.positionUid}, #{pt.name}, #{pt.enabled})")
    int insertPosition(@Param(value = "pt") Position position);

    @Update("<script>\n" +
            "\t UPDATE i_tb_position \n" +
            "     <set>  \n" +
            "        <if test=\"upt.name != null and upt.name != '' \">  \n" +
            "            p_name = #{upt.name},  \n" +
            "        </if>  \n" +
            "        <if test=\"upt.createDate != null and upt.createDate != '' \">  \n" +
            "            p_createDate = #{upt.createDate},  \n" +
            "        </if>    \n" +
            "        <if test=\"upt.enabled != null \">  \n" +
            "            p_enabled = #{upt.enabled}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE p_uid = #{upt.positionUid}; \n" +
            "     </script>")
    int updatePositionByPositionId(@Param("upt") Position position);

    @ResultMap(value = "positionMapper1")
    @Delete("DELETE FROM i_tb_position" +
            " WHERE p_uid = #{positionUid}")
    int deletePositionByPositionId(@Param(value = "positionUid") String positionUid);
}
