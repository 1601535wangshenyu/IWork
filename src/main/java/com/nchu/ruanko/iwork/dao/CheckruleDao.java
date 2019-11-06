package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Checkrule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CheckruleDao {

    @Results(id = "checkruleMapper1", value = {
            @Result(property = "checkruleUid", column = "cr_uid"),
            @Result(property = "siteposLat", column = "cr_siteposLat"),
            @Result(property = "siteposLng", column = "cr_siteposLng"),
            @Result(property = "siteradius", column = "cr_siteradius")
    })
    @Select("SELECT *" +
            " FROM i_tb_checkrule" +
            " WHERE cr_uid=#{uid}")
    Checkrule getCheckruleByCheckruleId(@Param(value = "uid") String checkruleUid);

    @ResultMap(value = "checkruleMapper1")
    @Select("SELECT *" +
            " FROM i_tb_checkrule")
    List<Checkrule> listAllCheckrule();

    @Insert("INSERT INTO i_tb_checkrule(cr_uid, cr_siteposLat, cr_siteposLng, cr_siteradius)" +
            " VALUE(#{cr.checkruleUid}, #{cr.siteposLat}, #{cr.siteposLng}, #{cr.siteradius})")
    int insertCheckrule(@Param("cr") Checkrule checkrule);

    @ResultMap(value = "checkruleMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_checkrule \n" +
            "     <set>  \n" +
            "        <if test=\"ucr.siteposLat != null and ucr.siteposLat != '' \">  \n" +
            "            cr_siteposLat = #{ucr.siteposLat},  \n" +
            "        </if>  \n" +
            "        <if test=\"ucr.siteposLng != null and ucr.siteposLng != '' \">  \n" +
            "            cr_siteposLng = #{ucr.siteposLng},  \n" +
            "        </if>    \n" +
            "        <if test=\"ucr.siteradius != null \">  \n" +
            "            cr_siteradius = #{ucr.siteradius}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE cr_uid = #{ucr.checkruleUid}; \n" +
            "     </script>")
    int updateCheckruleByCheckruleId(@Param("ucr") Checkrule checkrule);

    @ResultMap(value = "checkruleMapper1")
    @Delete("DELETE FROM i_tb_checkrule" +
            " WHERE cr_uid=#{uid}")
    int deleteCheckruleByCheckruleId(@Param("uid") String checkruleUid);
}
/*private String checkruleUid;
    private String siteposLat;
    private String siteposLng;
    private float siteradius;*/
