package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.PoliticsStatus;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PoliticsStatusDao {
    @Results(id = "politicsStatusMapper1", value = {
            @Result(property = "politicsStatusUId", column = "p_id"),
            @Result(property = "name", column = "p_name")
    })
    @Select("SELECT *" +
            " FROM i_tb_politicsstatus" +
            " WHERE p_id=#{uid}")
    PoliticsStatus getPoliticsStatusByPoliticsStatusUid(@Param(value = "uid") String politicsStatusUid);

    @ResultMap(value = "politicsStatusMapper1")
    @Select("SELECT *" +
            " FROM i_tb_politicsstatus")
    List<PoliticsStatus> listAllPoliticsStatus();

    @ResultMap(value = "politicsStatusMapper1")
    @Insert("INSERT INTO i_tb_politicsstatus(p_id, p_name)" +
            " VALUE(#{ps.politicsStatusUId}, #{ps.name})")
    int insertPoliticsStatus(@Param(value = "ps") PoliticsStatus politicsStatus);

    @Update("<script>\n" +
            "\t UPDATE i_tb_politicsstatus \n" +
            "     <set>  \n" +
            "        <if test=\"ups.name != null and ups.name != '' \">  \n" +
            "            p_name = #{ups.name},  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE p_id = #{ups.politicsStatusUId}; \n" +
            "     </script>")
    int updatePoliticsStatusByPoliticsStatusUid(@Param("ups") PoliticsStatus politicsStatus);

    @ResultMap(value = "politicsStatusMapper1")
    @Delete("DELETE FROM i_tb_politicsstatus" +
            " WHERE p_id = #{politicsStatusUId}")
    int deletePoliticsStatusByPoliticsStatusUid(@Param(value = "politicsStatusUId") String politicsStatusUId);
}
