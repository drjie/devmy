package com.lz.dao;

import com.lz.entity.Alleviation;
import com.lz.entity.AlleviationExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlleviationMapper {
    long countByExample(AlleviationExample example);

    int deleteByExample(AlleviationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alleviation record);

    int insertSelective(Alleviation record);

    List<Alleviation> selectByExampleWithBLOBs(AlleviationExample example);

    List<Alleviation> selectByExample(AlleviationExample example);

    Alleviation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExampleWithBLOBs(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExample(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByPrimaryKeySelective(Alleviation record);

    int updateByPrimaryKeyWithBLOBs(Alleviation record);

    int updateByPrimaryKey(Alleviation record);

    int getIncrement(Alleviation alleviation);

    int click(@Param("id") Long id, @Param("lastClickTime") Date lastClickTime);

}