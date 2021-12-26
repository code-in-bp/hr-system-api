package com.codeinbp.hr.repository;

import com.codeinbp.hr.model.Hire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HireRepository {

    @Select("SELECT * FROM hires")
    List<Hire> findAllHires();

    @Select("SELECT * FROM hires WHERE id = #{id}")
    Hire findHiresById(int id);


}
