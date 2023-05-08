package com.xzzzf.mapper;

import com.xzzzf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user where uid = #{uid}")
    User getUserById(Integer uid);
}
