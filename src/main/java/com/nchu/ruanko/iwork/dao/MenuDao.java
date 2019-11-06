package com.nchu.ruanko.iwork.dao;

import com.nchu.ruanko.iwork.domain.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuDao {

    @Results(id = "menuMapper1", value = {
            @Result(property = "menuUid", column = "m_uid"),
            @Result(property = "url", column = "m_url"),
            @Result(property = "path", column = "m_path"),
            @Result(property = "component", column = "m_component"),
            @Result(property = "name", column = "m_name"),
            @Result(property = "keepAlive", column = "m_keepAlive"),
            @Result(property = "requireAuth", column = "m_requireAuth"),
            @Result(property = "parent", column = "m_parentId", one = @One(select = "com.nchu.ruanko.iwork.dao.MenuDao.getMenuByMenuId")),
            @Result(property = "enabled", column = "m_enabled")
    })
    @Select("SELECT *" +
            " FROM i_tb_menu" +
            " WHERE m_uid = #{uid}")
    Menu getMenuByMenuId(@Param(value = "uid") String menuUid);

    @ResultMap(value = "menuMapper1")
    @Select("SELECT *" +
            " FROM i_tb_menu")
    List<Menu> listAllMenu();

    @Insert("INSERT INTO i_tb_menu(m_uid, m_url, m_path, m_component, m_name, m_keepAlive, m_requireAuth, m_parentId, m_enabled)" +
            " VALUE(#{me.menuUid}, #{me.url}, #{me.path}, #{me.component}, #{me.name}, #{me.keepAlive}, #{me.requireAuth}, #{me.parent.menuUid}, #{me.enabled})")
    int insertMenu(@Param("me") Menu menu);

    @ResultMap(value = "menuMapper1")
    @Update("<script>\n" +
            "\t UPDATE i_tb_menu \n" +
            "     <set>  \n" +
            "        <if test=\"ume.url != null and ume.url != '' \">  \n" +
            "            m_url = #{ume.url},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.path != null and ume.path != '' \">  \n" +
            "            m_path = #{ume.path},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.component != null and ume.component != '' \">  \n" +
            "            m_component = #{ume.component},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.name != null and ume.name != '' \">  \n" +
            "            m_name = #{ume.name},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.keepAlive != null \">  \n" +
            "            m_keepAlive = #{ume.keepAlive},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.requireAuth != null \">  \n" +
            "            m_requireAuth = #{ume.requireAuth},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.parent != null \">  \n" +
            "            m_parentId = #{ume.parent.menuUid},  \n" +
            "        </if>  \n" +
            "        <if test=\"ume.enabled != null \">  \n" +
            "            m_enabled = #{ume.enabled}  \n" +
            "        </if>  \n" +
            "     </set>  \n" +
            "\t\tWHERE m_uid = #{ume.menuUid}; \n" +
            "     </script>")
    int updateMenuByMenuId(@Param("ume") Menu menu);

    @ResultMap(value = "menuMapper1")
    @Delete("DELETE FROM i_tb_menu" +
            " WHERE m_uid = #{uid}")
    int deleteMenuByMenuId(@Param("uid") String menuUid);
}
/*private String menuUid;
    private String url;
    private String path;
    private String component;
    private String name;
    private int keepAlive;
    private int requireAuth;
    private Menu parent;
    private int enabled;*/