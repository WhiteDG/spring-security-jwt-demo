package cc.white.springsecurityjwtdemo.dao;

import cc.white.springsecurityjwtdemo.model.Role;
import cc.white.springsecurityjwtdemo.model.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<Role> selectRoleByUserId(Integer id);
}