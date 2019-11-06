package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Results(id = "roleMapper1", value = {
            @Result(property = "roleUid", column = "r_uid"),
            @Result(property = "name", column = "r_name"),
            @Result(property = "nameZh", column = "r_nameZh"),
            @Result(property = "description", column = "r_description")
    })
    @Select("SELECT *" +
            " FROM i_tb_role" +
            " WHERE r_uid = #{uid}")
    Role getRoleByRoleId(@Param(value = "uid") String roleUid);

    @ResultMap(value = "roleMapper1")
    @Select("SELECT *" +
            " FROM i_tb_role")
    List<Role> listAllRole();

    @ResultMap(value = "roleMapper1")
    @Insert("INSERT INTO i_tb_role(r_uid, r_name, r_nameZh, r_description)" +
            " VALUE(#{rol.roleUid}, #{rol.name}, #{rol.nameZh}, #{rol.description})")
    int insertRole(@Param("rol") Role role);

    @ResultMap(value = "roleMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_role \n" +
            "     <set>  \n" +
            "        <if test=\"urol.name != null and urol.name != '' \">  \n" +
            "            r_name = #{urol.name},  \n" +
            "        </if>  \n" +
            "        <if test=\"urol.nameZh != null and urol.nameZh != '' \">  \n" +
            "            r_nameZh = #{urol.nameZh},  \n" +
            "        </if>  \n" +
            "        <if test=\"urol.description != null and urol.description != '' \">  \n" +
            "            r_description = #{urol.description}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE r_uid = #{urol.roleUid}; \n" +
            "     </script>")
    int updateRoleByRoleId(@Param("urol") Role role);

    @ResultMap(value = "roleMapper1")
    @Delete("DELETE FROM i_tb_role" +
            " WHERE r_uid = #{uid}")
    int deleteRoleByRoleId(@Param(value = "uid") String roleUid);
}
/*private String roleUid;
    private String name;
    private String nameZh;
    private String description;*/