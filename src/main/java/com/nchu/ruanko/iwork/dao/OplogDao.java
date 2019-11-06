package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Oplog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OplogDao {

    @Results(id = "oplogMapper1", value = {
            @Result(property = "oplogUid", column = "o_uid"),
            @Result(property = "addDate", column = "o_addDate"),
            @Result(property = "operate", column = "o_operate"),
            @Result(property = "user", column = "o_userid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId"))
    })
    @Select("SELECT *" +
            " FROM i_tb_oplog" +
            " WHERE o_uid=#{uid}")
    Oplog getOplogByOplogId(@Param(value = "uid") String oplogUid);

    @ResultMap(value = "oplogMapper1")
    @Select("SELECT *" +
            " FROM i_tb_oplog")
    List<Oplog> listAllOplog();

    @ResultMap(value = "oplogMapper1")
    @Insert("INSERT INTO i_tb_oplog(o_uid, o_addDate, o_operate, o_userid)" +
            " VALUE(#{op.oplogUid}, #{op.addDate}, #{op.operate}, #{op.user.userUid})")
    int insertOplog(@Param("op") Oplog oplog);

    @ResultMap(value = "oplogMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_oplog \n" +
            "     <set>  \n" +
            "        <if test=\"uop.addDate != null and uop.addDate != '' \">  \n" +
            "            o_addDate = #{uop.addDate},  \n" +
            "        </if>  \n" +
            "        <if test=\"uop.operate != null and uop.operate != '' \">  \n" +
            "            o_operate = #{uop.operate},  \n" +
            "        </if>    \n" +
            "        <if test=\"uop.user != null \">  \n" +
            "            o_userid = #{uop.user.userUid}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE o_uid = #{uop.oplogUid}; \n" +
            "     </script>")
    int updateOplogByOplogId(@Param("uop") Oplog oplog);

    @ResultMap(value = "oplogMapper1")
    @Delete("DELETE FROM i_tb_oplog" +
            " WHERE o_uid = #{uid}")
    int deleteOplogByOplogId(@Param("uid") String oplogUid);
}

/*private String oplogUid;
    private Date addDate;
    private String operate;
    private User user;*/
