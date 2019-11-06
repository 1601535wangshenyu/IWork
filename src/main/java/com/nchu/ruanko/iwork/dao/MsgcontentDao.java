package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Msgcontent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MsgcontentDao {

    @Results(id = "msgcontentMapper1", value = {
            @Result(property = "msgcontentUid", column = "m_uid"),
            @Result(property = "title", column = "m_title"),
            @Result(property = "message", column = "m_message"),
            @Result(property = "createDate", column = "m_createDate")
    })
    @Select("SELECT *" +
            " FROM i_tb_msgcontent" +
            " WHERE m_uid = #{uid}")
    Msgcontent getMsgcontentByMsgcontentId(@Param(value = "uid") String msgcontentUid);

    @ResultMap(value = "msgcontentMapper1")
    @Select("SELECT *" +
            " FROM i_tb_msgcontent")
    List<Msgcontent> listAllMsgcontent();

    @ResultMap(value = "msgcontentMapper1")
    @Insert("INSERT INTO i_tb_msgcontent(m_uid, m_title, m_message)" +
            " VALUE(#{msg.msgcontentUid}, #{msg.title}, #{msg.message})")
    int insertMsgcontent(@Param("msg") Msgcontent msgcontent);

    @ResultMap(value = "msgcontentMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_msgcontent \n" +
            "     <set>  \n" +
            "        <if test=\"umsg.title != null and umsg.title != '' \">  \n" +
            "            m_title = #{umsg.title},  \n" +
            "        </if>    \n" +
            "        <if test=\"umsg.message != null and umsg.message != '' \">  \n" +
            "            m_message = #{umsg.message}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE m_uid = #{umsg.msgcontentUid}; \n" +
            "     </script>")
    int updateMsgcontentByMsgcontentId(@Param("umsg") Msgcontent msgcontent);

    @ResultMap(value = "msgcontentMapper1")
    @Delete("DELETE FROM i_tb_msgcontent" +
            " WHERE m_uid = #{uid}")
    int deleteMsgcontentByMsgcontentId(@Param("uid") String msgcontentUid);
}
/*private String msgcontentUid;
    private String title;
    private String message;
    private Timestamp createDate;*/
