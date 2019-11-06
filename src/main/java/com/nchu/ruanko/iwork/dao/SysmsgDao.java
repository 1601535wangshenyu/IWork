package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Sysmsg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysmsgDao {

    @Results(id = "sysmsgMapper1", value = {
            @Result(property = "sysmsgUid", column = "s_uid"),
            @Result(property = "msgcontent", column = "s_msgid", one = @One(select = "com.nchu.ruanko.iwork.dao.MsgcontentDao.getMsgcontentByMsgcontentId")),
            @Result(property = "type", column = "s_type"),
            @Result(property = "user", column = "s_userid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "state", column = "s_state")
    })
    @Select("SELECT *" +
            " FROM i_tb_sysmsg" +
            " WHERE s_uid=#{uid}")
    Sysmsg getSysmsgBySysmsgId(@Param(value = "uid") String sysmsgUid);

    @ResultMap(value = "sysmsgMapper1")
    @Select("SELECT *" +
            " FROM i_tb_sysmsg")
    List<Sysmsg> listAllSysmsg();

    @Insert("INSERT INTO i_tb_sysmsg(s_uid, s_msgid, s_type, s_userid, s_state)" +
            " VALUE(#{sys.sysmsgUid}, #{sys.msgcontent.msgcontentUid}, #{sys.type}, #{sys.user.userUid}, #{sys.state})")
    int insertSysmsg(@Param("sys") Sysmsg sysmsg);

    @Update("<script>\n" +
            "\t UPDATE i_tb_sysmsg \n" +
            "     <set>  \n" +
            "        <if test=\"usys.msgcontent != null \">  \n" +
            "            s_msgid = #{usys.msgcontent.msgcontentUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"usys.type != null \">  \n" +
            "            s_type = #{usys.type},  \n" +
            "        </if>  \n" +
            "        <if test=\"usys.user != null \">  \n" +
            "            s_userid = #{usys.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"usys.state != null \">  \n" +
            "            s_state = #{usys.state}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE s_uid = #{usys.sysmsgUid}; \n" +
            "     </script>")
    int updateSysmsgBySysmsgId(@Param("usys") Sysmsg sysmsg);

    @Delete("DELETE FROM i_tb_sysmsg" +
            " WHERE s_uid=#{uid}")
    int deleteSysmsgBySysmsgId(@Param("uid") String sysmsgUid);
}
/*private String sysmsgUid;
    private Msgcontent msgcontent;
    private int type;
    private User user;
    private int state;*/
