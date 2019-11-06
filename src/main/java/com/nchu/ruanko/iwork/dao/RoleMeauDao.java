package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.RoleMeau;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMeauDao {

    @Results(id = "roleMeauMapper1", value = {
            @Result(property = "roleMeauUid", column = "r_m_uid"),
            @Result(property = "role", column = "r_m_roleid", one = @One(select = "com.nchu.ruanko.iwork.dao.RoleDao.getRoleByRoleId")),
            @Result(property = "menu", column = "r_m_meauid", one = @One(select = "com.nchu.ruanko.iwork.dao.MenuDao.getMenuByMenuId"))
    })
    @Select("SELECT *" +
            " FROM i_tb_role_meau" +
            " WHERE r_m_uid = #{uid}")
    RoleMeau getRoleMeauByRoleMeauId(@Param(value = "uid") String roleMeauUid);

    @ResultMap(value = "roleMeauMapper1")
    @Select("SELECT *" +
            " FROM i_tb_role_meau")
    List<RoleMeau> listAllRoleMeau();

    @ResultMap(value = "roleMeauMapper1")
    @Insert("INSERT INTO i_tb_role_meau(r_m_uid, r_m_roleid, r_m_meauid)" +
            " VALUE(#{rm.roleMeauUid}, #{rm.role.roleUid}, #{rm.menu.menuUid})")
    int insertRoleMeau(@Param("rm") RoleMeau roleMeau);

    @ResultMap(value = "roleMeauMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_role_meau \n" +
            "     <set>  \n" +
            "        <if test=\"urm.role != null \">  \n" +
            "            r_m_roleid = #{urm.role.roleUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"urm.menu != null \">  \n" +
            "            r_m_meauid = #{urm.menu.menuUid}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE r_m_uid = #{urm.roleMeauUid}; \n" +
            "     </script>")
    int updateRoleMeauByRoleMeauId(@Param("urm") RoleMeau roleMeau);

    @ResultMap(value = "roleMeauMapper1")
    @Delete("DELETE FROM i_tb_role_meau" +
            " WHERE r_m_uid = #{uid}")
    int deleteRoleMeauByRoleMeauId(@Param("uid") String roleMeauUid);
}
