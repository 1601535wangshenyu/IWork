package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Check;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CheckDao {

    @Results(id = "checkMapper1", value = {
            @Result(property = "checkUid", column = "c_uid"),
            @Result(property = "user", column = "c_userId", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "siteposLat", column = "c_siteposLat"),
            @Result(property = "siteposLng", column = "c_siteposLng"),
            @Result(property = "date", column = "c_date")
    })
    @Select("SELECT *" +
            " FROM i_tb_check" +
            " WHERE c_uid = #{uid}")
    Check getCheckByCheckId(@Param(value = "uid") String checkUid);

    @ResultMap(value = "checkMapper1")
    @Select("SELECT *" +
            " FROM i_tb_check")
    List<Check> listAllCheck();

    @ResultMap(value = "checkMapper1")
    @Insert("INSERT INTO i_tb_check(c_uid, c_userId, c_siteposLat, c_siteposLng, c_date)" +
            " VALUE(#{ch.checkUid}, #{ch.user.userUid}, #{ch.siteposLat}, #{ch.siteposLng}, #{ch.date})")
    int insertCheck(@Param("ch") Check check);

    @ResultMap(value = "checkMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_check \n" +
            "     <set>  \n" +
            "        <if test=\"uch.user != null \">  \n" +
            "            c_userId = #{uch.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uch.siteposLat != null and uch.siteposLat != '' \">  \n" +
            "            c_siteposLat = #{uch.siteposLat},  \n" +
            "        </if>    \n" +
            "        <if test=\"uch.siteposLng != null and uch.siteposLng != '' \">  \n" +
            "            c_siteposLng = #{uch.siteposLng}  \n" +
            "        </if>  \n" +
            "        <if test=\"uch.date != null and uch.date != '' \">  \n" +
            "            c_date = #{uch.date}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE c_uid = #{uch.checkUid}; \n" +
            "     </script>")
    int updateCheckByCheckId(@Param("uch") Check check);

    @ResultMap(value = "checkMapper1")
    @Delete("DELETE FROM i_tb_check" +
            " WHERE c_uid = #{uid}")
    int deleteCheckByCheckId(@Param("uid") String checkUid);
}

/*private String checkUid;
    private User user;
    private String siteposLat;
    private String siteposLng;
    private Date date;*/
