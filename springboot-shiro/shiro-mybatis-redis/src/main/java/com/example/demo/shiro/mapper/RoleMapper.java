package com.example.demo.shiro.mapper;


import com.example.demo.shiro.entity.Role;
import com.example.demo.shiro.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 路径：com.example.demo.shiro.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:45
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface RoleMapper extends MyMapper<Role> {

    public List<Role> queryRoleListWithSelected(Integer id);
}