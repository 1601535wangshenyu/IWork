package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRoleDao {

    @Results(id = "userRoleMapper1", value = {
            @Result(property = "userRoleUid", column = "u_r_uid"),
            @Result(property = "user", column = "u_r_userid", one = @One(select = "com.nchu.ruanko.iwork.dao.UserDao.getUserByUserId")),
            @Result(property = "role", column = "u_r_roleid", one = @One(select = "com.nchu.ruanko.iwork.dao.RoleDao.getRoleByRoleId")),
            @Result(property = "rtime", column = "u_r_rtime")
    })
    @Select("SELECT *" +
            " FROM i_tb_user_role" +
            " WHERE u_r_uid = #{uid}")
    UserRole getUserRoleByUserRoleId(@Param(value = "uid") String userRoleUid);

    @ResultMap(value = "userRoleMapper1")
    @Select("SELECT *" +
            " FROM i_tb_user_role")
    List<UserRole> listAllUserRole();

    @Insert("INSERT INTO i_tb_user_role(u_r_uid, u_r_userid, u_r_roleid, u_r_rtime)" +
            " VALUE(#{ur.userRoleUid}, #{ur.user.userUid}, #{ur.role.roleUid}, #{ur.rtime})")
    int insertUserRole(@Param("ur") UserRole userRole);

    @Update("<script>\n" +
            "\t UPDATE i_tb_user_role \n" +
            "     <set>  \n" +
            "        <if test=\"uur.user != null \">  \n" +
            "            u_r_userid = #{uur.user.userUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uur.role != null \">  \n" +
            "            u_r_roleid = #{uur.role.roleUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"uur.rtime != null and uur.rtime != '' \">  \n" +
            "            u_r_rtime = #{uur.rtime}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE u_r_uid = #{uur.userRoleUid}; \n" +
            "     </script>")
    int updateUserRoleByUserRoleId(@Param("uur") UserRole userRole);

    @Delete("DELETE FROM i_tb_user_role" +
            " WHERE u_r_uid = #{uid}")
    int deleteUserRoleByUserRoleId(@Param("uid") String userRoleUid);
}
/*private String userRoleUid;
    private User user;
    private Role role;
    private String rtime;*/
