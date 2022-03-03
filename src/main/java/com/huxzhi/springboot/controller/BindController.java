package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.exception.ServiceException;
import com.huxzhi.springboot.mapper.BindMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.huxzhi.springboot.common.Constants.CODE_600;

@RestController
@RequestMapping("/bind")
public class BindController {
    @Resource
    BindMapper bindMapper;

    @GetMapping("/saveinfo")
    public Result saveInfo(@RequestParam Integer userId,
                           @RequestParam Integer infoId) {
        try {
            bindMapper.saveInfo(userId, infoId);
        } catch (Exception e) {
            throw new ServiceException(CODE_600, "一个角色只能绑定一个人口信息，请先解除绑定");
        }
        return Result.success();
    }

    @GetMapping("/saveillegal")
    public Result saveIllegal(@RequestParam Integer userId,
                              @RequestParam Integer illegalId) {

        try {
            bindMapper.saveIllegal(userId, illegalId);
        } catch (RuntimeException e) {
            throw new ServiceException(CODE_600, "角色Id不存在或绑定重复");
        }
        return Result.success();
    }

    @GetMapping("/saveresidence")
    public Result saveResidence(@RequestParam Integer userId,
                                @RequestParam Integer residenceId) {
        try {
            bindMapper.saveResidence(userId, residenceId);
        } catch (RuntimeException e) {
            throw new ServiceException(CODE_600, "角色Id不存在或绑定重复");
        }
        return Result.success();
    }

    @GetMapping("/savebirth")
    public Result saveBirth(@RequestParam Integer userId,
                            @RequestParam Integer birthId) {
        try {
            bindMapper.saveBirth(userId, birthId);
        } catch (RuntimeException e) {
            throw new ServiceException(CODE_600, "角色Id不存在或绑定重复");
        }
        return Result.success();
    }

}
