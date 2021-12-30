package com.codeinbp.hr.repository;

import com.codeinbp.hr.model.Hire;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HireRepository {

    @Select("SELECT * FROM hires")
    List<Hire> findAllHires();

    @Select("SELECT * FROM hires WHERE id = #{id}")
    Hire findHiresById(int id);

    @Insert("INSERT INTO hires(id, firstName, lastName, email, serialNumber, hireDate, contractType, photo) VALUES (#{id}, #{firstName}, #{lastName}, #{email}, #{serialNumber}, #{hireDate}, #{contractType}, #{photo})")
    int addNewHire(Hire hire);

    @Delete("DELETE FROM hires where id = #{id}")
    int deleteHireById(int id);


    @Update("UPDATE hires set firstName=#{firstName}, lastName=#{lastName}, email=#{email}, serialNumber=#{serialNumber}, hireDate=#{hireDate}, contractType=#{contractType}, photo=#{photo}")
    int updateHire(Hire hire);

}
