package com.huxzhi.springboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huxzhi.springboot.entity.Menu;
import com.huxzhi.springboot.entity.Role;
import com.huxzhi.springboot.entity.RoleMenu;
import com.huxzhi.springboot.mapper.RoleMapper;
import com.huxzhi.springboot.mapper.RoleMenuMapper;
import com.huxzhi.springboot.service.IMenuService;
import com.huxzhi.springboot.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private IMenuService menuService;

    @Transactional
    @Override
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {
        // 先删除当前角色id所有的绑定关系
        //在 Mapper 中写了
//        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("role_id", roleId);
//        roleMenuMapper.delete(queryWrapper);


        roleMenuMapper.deleteByRoleId(roleId);

        // 再把前端传过来的菜单id数组绑定到当前的这个角色id上去
        // 不能在循环遍历里面增加数据
        List<Integer> menuIdsCopy = CollUtil.newArrayList(menuIds);

        for (Integer menuId : menuIds) {
            Menu menu = menuService.getById(menuId);

            if (menu.getPid() != null && !menuIdsCopy.contains(menu.getPid())) {
                // 那么我们就得补上这个父级id
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getPid());
                roleMenuMapper.insert(roleMenu);
                menuIdsCopy.add(menu.getPid());
            }
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {

        return roleMenuMapper.selectByRoleId(roleId);
    }

}

