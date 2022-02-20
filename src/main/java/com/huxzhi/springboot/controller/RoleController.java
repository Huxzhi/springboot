package com.huxzhi.springboot.controller;

//导入需要的包
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;

import com.huxzhi.springboot.service.IRoleService;
import com.huxzhi.springboot.entity.Role;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-20
 */
@RestController
@RequestMapping("/role")
        public class RoleController {
    
@Resource
private IRoleService roleService;

//新增或者更新
@PostMapping
public boolean save(@RequestBody Role  role){
        return roleService.saveOrUpdate(role);
        }
@DeleteMapping("/{id}")
public boolean delete(@PathVariable Integer id){
        return roleService.removeById(id);
        }

@PostMapping("/del/batch")
public boolean deleteBatch(@RequestBody List<Integer> ids){
        return roleService.removeByIds(ids);
        }

//查询所有数据
@GetMapping
public List<Role> findAll(){
        return roleService.list();
        }

@GetMapping("/{id}")
public Role findOne(@PathVariable Integer id){
        return roleService.getById(id);
        }
@GetMapping("/page")
public Page<Role> findPage(@RequestParam Integer pageNum,
@RequestParam Integer pageSize){

        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();

        //进行倒序输出
        queryWrapper.orderByDesc("id");
        return roleService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
        }

