package com.xzzzf.mapper;

import com.xzzzf.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    @Select("select * from tb_book where bid = #{bid}")
    Book getBookById(Integer bid);
}
