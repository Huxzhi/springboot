package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.entity.Residence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-23
 */
@Mapper
public interface ResidenceMapper extends BaseMapper<Residence> {
    /**
     * 根据暂住证记录反查用户id
     */
    @Select("SELECT id_user id FROM fp_user_residence WHERE id_residence = #{id_residence}")
    List<Integer> getUserIdByResidence(@Param("id_residence") Integer id_residence);


}
