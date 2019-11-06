package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Nation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NationDao {
    @Results(id = "nationMapper1", value = {
            @Result(property = "nationUid", column = "n_id"),
            @Result(property = "name", column = "n_name")
    })
    @Select("SELECT *" +
            " FROM i_tb_nation" +
            " WHERE n_id=#{uid}")
    Nation getNationByNationUid(@Param(value = "uid") String nationUid);

    @ResultMap(value = "nationMapper1")
    @Select("SELECT *" +
            " FROM i_tb_nation")
    List<Nation> iistAllNation();

    @ResultMap(value = "nationMapper1")
    @Insert("INSERT INTO i_tb_nation(n_id, n_name)" +
            " VALUE(#{nation.nationUid}, #{nation.name})")
    int insertNation(@Param(value = "nation") Nation nation);

    @Update("<script>\n" +
            "\t UPDATE i_tb_nation \n" +
            "     <set>  \n" +
            "        <if test=\"nat.name != null and nat.name != '' \">  \n" +
            "            n_name = #{nat.name},  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE n_id = #{nat.nationUid}; \n" +
            "     </script>")
    int updateNationByNationId(@Param("nat") Nation nation);

    @ResultMap(value = "nationMapper1")
    @Delete("DELETE FROM i_tb_nation" +
            " WHERE n_id = #{nationUid}")
    int deleteNationByNationId(@Param(value = "nationUid") Integer nationUid);
}
