package com.xzzzf.mapper;

import com.xzzzf.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("select * from tb_borrow where uid = #{uid}")
    List<Borrow> getBorrowsByUid(Integer uid);

    @Select("select * from tb_borrow where bid = #{bid}")
    List<Borrow> getBorrowsByBid(Integer bid);

    @Select("select * from tb_borrow where uid = #{uid} and bid = #{bid}")
    Borrow getBorrow(@Param("uid") Integer uid,@Param("bid") Integer bid);
}
